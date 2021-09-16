/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
import java.util.*;
class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return node;
        }
        
        HashMap<Node,Node> vistedMap = new HashMap<>();
        LinkedList<Node> queue = new LinkedList<>();
        vistedMap.put(node, new Node(node.val, new ArrayList<Node>()));
        queue.add(node);
        while(!queue.isEmpty()){
            Node curr = queue.remove();
            for(Node i:curr.neighbors){
                if(!vistedMap.containsKey(i)){
                    vistedMap.put(i, new Node(i.val, new ArrayList<Node>()));
                    queue.add(i);
                }
                vistedMap.get(curr).neighbors.add(vistedMap.get(i));
            }
        }
        return vistedMap.get(node);
    }
}