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
        //insertRecursive(root,90);
        insertIterative(root,7);
//        System.out.println(search(root,16));
////        System.out.println(searchIterative(root,16));
        //  inorderTraversalInOrder(root);
        inorderTraversalInOrder(root);
    }
//    public static Node deleteRecursive(Node root,int data){
//
//    }
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

    public static Node insertRecursive(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (root.data < data) {
            root.right = insertRecursive(root.right, data);
        } else if (root.data > data) {
            root.left = insertRecursive(root.left, data);
        }
        return root;
    }

    public static Node insertIterative(Node root, int data) {
        Node temp = new Node(data);
        Node present = null, curr = root;
        while (curr != null) {
            present = curr;
            if (curr.data > data) {
                curr = curr.left;
            } else if (curr.data < data) {
                curr = curr.right;
            }
        }
        if (present == null) {
            return temp;
        } else if (present.data > data) {
            present.left = temp;
        } else {
            present.right = temp;
        }
        return root;
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
