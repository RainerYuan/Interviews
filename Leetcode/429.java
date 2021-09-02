import java.util.ArrayList;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        helper(root, 0, ans);
        return ans;

    }

    private void helper(Node cur, int level, List<List<Integer>> ans) {
        if (cur == null) {
            return;
        }
        // review this smaller or equal to sign this is because size start at 1 when
        // there is only one element in array while level start at 0

        while (ans.size() <= level) {
            ans.add(new ArrayList<Integer>());
        }
        // should be here rather than in the loop below, got it wrong the first time.
        // review
        ans.get(level).add(cur.val);
        for (Node node : cur.children) {
            helper(node, level + 1, ans);
        }
    }
}