package Tree;

import java.util.HashMap;

public class TreeExample {

    static Node prev = null;
    static int preIndex = 0;

    public static void main(String[] args) {
        Node root = new Node(12);
        root.left = new Node(8);
        root.left.left = new Node(9);
        root.left.right = new Node(9);
        root.right = new Node(4);
        root.right.left = new Node(1);
        root.right.right = new Node(3);
        Node node = getLinkedListUsingInOrderTraversal(root);
        while (node != null) {
            System.out.println(node.data);
            node = node.right;
        }
    }

    public static Node getLinkedListUsingInOrderTraversal(Node root) {
        if (root == null) {
            return root;
        }
        Node head = getLinkedListUsingInOrderTraversal(root.left);
        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        getLinkedListUsingInOrderTraversal(root.right);
        return head;
    }

    public static Node makeBTFromINAndPre(int in[], int pr[], int is, int ie) {
        if (is > ie) {
            return null;
        }
        Node root = new Node(pr[preIndex++]);
        int inIndex = 0;
        for (int i = is; i <= ie; i++) {
            if (in[i] == root.data) {
                inIndex = i;
                break;
            }
        }
        root.left = makeBTFromINAndPre(in, pr, is, inIndex - 1);
        root.left = makeBTFromINAndPre(in, pr, inIndex + 1, ie);
        return root;
    }

    public static Node makeBTFromINAndPost(int in[], int pr[], int is, int ie, HashMap<Integer, Integer> inOrderMap, int preIndex) {
        if (is > ie) {
            return null;
        }
        Node root = new Node(pr[preIndex--]);
        int inIndex = inOrderMap.get(root.data);
        root.left = makeBTFromINAndPost(in, pr, is, inIndex - 1, inOrderMap, preIndex);
        root.right = makeBTFromINAndPost(in, pr, inIndex + 1, ie, inOrderMap, preIndex);
        return root;
    }
}
