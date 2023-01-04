class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root== null)return ans;
        
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> bfs = new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            int s =q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<s;i++){
                TreeNode tn = q.poll();
                temp.add(tn.val);
            if(tn.right!=null){
                q.add(tn.right);
            }
            
            if(tn.left!=null){
                q.add(tn.left);
            }
            }
            bfs.add(temp);
        }
        for(List<Integer> temp:bfs){
            ans.add(temp.get(0));
        }
        return ans;
        
    }
    
}
