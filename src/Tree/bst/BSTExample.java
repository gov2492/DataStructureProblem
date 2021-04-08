package Tree.bst;

import java.util.Stack;

public class BSTExample {

    public static void main(String[] args) {
        Node root = new Node(15);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.right = new Node(20);
        root.right.left = new Node(18);
        root.right.left.left = new Node(16);
        root.right.right = new Node(80);
//        System.out.println(search(root,16));
////        System.out.println(searchIterative(root,16));
        //  inorderTraversalInOrder(root);
        preOrderTraversal(root);
    }

    public static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        } else if (root.data == key) {
            return true;
        } else if (root.data < key) {
            return search(root.right, key);
        } else {
            return search(root.left, key);
        }
    }

    public static boolean searchIterative(Node root, int key) {
        while (root != null) {
            if (root.data == key) {
                return true;
            } else if (root.data < key) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return false;
    }

    public static void inorderTraversalInOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while (curr != null || !stack.empty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.data + ",");
            curr = curr.right;
        }
    }

    public static void preOrderTraversal(Node root) {
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                System.out.print(curr.data + ",");
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }
    }

    
}
