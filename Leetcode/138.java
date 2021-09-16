import java.util.*;

class Solution 1{

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node copy = new Node(head.val);
        HashMap<Node, Node> Map = new HashMap<>();
        Map.put(head, copy);
        Node curr = head;
        Node copyCurr = copy;
        while (curr != null) {
            if (curr.next == null) {
                copyCurr.next = null;
            } else if (!Map.containsKey(curr.next)) {
                Node copyNext = new Node(curr.next.val);
                Map.put(curr.next, copyNext);
                copyCurr.next = copyNext;
            } else {
                copyCurr.next = Map.get(curr.next);
            }

            if (curr.random == null) {
                copyCurr.random = null;
            } else if (!Map.containsKey(curr.random)) {
                Node copyRandom = new Node(curr.random.val);
                Map.put(curr.random, copyRandom);
                copyCurr.random = copyRandom;
            } else {
                copyCurr.random = Map.get(curr.random);
            }
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        return copy;

    }
}

public class Solution2 {
    // Visited dictionary to hold old node reference as "key" and new node reference
    // as the "value"
    HashMap<Node, Node> visited = new HashMap<Node, Node>();

    public Node getClonedNode(Node node) {
        // If the node exists then
        if (node != null) {
            // Check if the node is in the visited dictionary
            if (this.visited.containsKey(node)) {
                // If its in the visited dictionary then return the new node reference from the
                // dictionary
                return this.visited.get(node);
            } else {
                // Otherwise create a new node, add to the dictionary and return it
                this.visited.put(node, new Node(node.val, null, null));
                return this.visited.get(node);
            }
        }
        return null;
    }

    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        Node oldNode = head;

        // Creating the new head node.
        Node newNode = new Node(oldNode.val);
        this.visited.put(oldNode, newNode);

        // Iterate on the linked list until all nodes are cloned.
        while (oldNode != null) {
            // Get the clones of the nodes referenced by random and next pointers.
            newNode.random = this.getClonedNode(oldNode.random);
            newNode.next = this.getClonedNode(oldNode.next);

            // Move one step ahead in the linked list.
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return this.visited.get(head);
    }
}