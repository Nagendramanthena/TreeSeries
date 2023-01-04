

*********************************************/

Draw vertical lines in the tree the last node in every line will be in the bottom view of the binary tree


public class Solution {
    public static ArrayList<Integer> bottomView(BinaryTreeNode root) {
         // Write your code here.  
        
        ArrayList<Integer> ans = new ArrayList<>();
        TreeMap<Integer,Integer> hm = new TreeMap<>();
        
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(root,0));
        
        while(!q.isEmpty()){
            Node n = q.poll();
            int ch = n.column;
            BinaryTreeNode bn = n.cur;
            
            if(hm.containsKey(ch)){
                hm.replace(ch,bn.val);
            }
            else hm.put(ch,bn.val);
            
            if(bn.left!=null){
                q.add(new Node(bn.left,ch-1));
            }
            
            if(bn.right!=null){
                q.add(new Node(bn.right,ch+1));
            }
        }
        Set<Integer> set1 = hm.keySet();
        
       for(Integer key:set1){
           ans.add(hm.get(key));
       }
        return ans;
    }
}

class Node{
    BinaryTreeNode cur;
    int column;
    
    public Node(BinaryTreeNode cur,int c){
        this.cur = cur;
        this.column = c;
    }
}


Tc - O(N)
Sc - O(N)
