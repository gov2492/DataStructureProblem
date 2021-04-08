package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class InorderTraversal {
    static int maxLevel = 0;

    public static void main(String[] args) {
        Node root = new Node(12);
        root.left = new Node(8);
        root.left.left=new Node(9);
        root.left.right=new Node(9);
        root.right = new Node(4);
        root.right.left = new Node(1);
        root.right.right = new Node(3);
//        inOrder(root);
//        System.out.println();
//        preOrder(root);
//        System.out.println();
//        postOrder(root);
//        System.out.println();
//        System.out.println("Height of tree:" + height(root));
//        printKLevel(root, 1);

        // printLevelOrder(root);
        //printLevelOrderByLineChange1(root);
        // System.out.println(treesize(root));
        //  System.out.println(maxValue2(root));
        //  System.out.println(maxValue(root));
        // leftView(root, 1);
        //System.out.println(isCsum(root));
        //leftView1(root);
        System.out.println(widthBinaryTree(root));
    }

    public static int widthBinaryTree(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int maxwidth = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            maxwidth = Math.max(maxwidth, count);
            for (int i = 0; i < count; i++) {
                Node node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return maxwidth;
    }

    public static int isBalanced(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = isBalanced(root.left);
        if (lh == -1) {
            return -1;
        }
        int rh = isBalanced(root.left);
        if (rh == -1) {
            return -1;
        }
        if (Math.abs(lh - rh) > 1) {
            return -1;
        }
        return Math.max(lh, rh) + 1;
    }

    public static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + ",");
            inOrder(root.right);
        }
    }

    public static void preOrder(Node root) {

        if (root != null) {
            System.out.print(root.data + ",");
            preOrder(root.left);
            preOrder(root.right);
        }

    }

    public static void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + ",");
        }
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static void printKLevel(Node root, int k) {
        if (root == null) {
            return;
        }
        if (k == 0) {
            System.out.print(root.data + ",");
        } else {
            printKLevel(root.left, k - 1);
            printKLevel(root.right, k - 1);
        }
    }

    public static void printLevelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.print(curr.data + " ");
            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
    }

    public static void printLevelOrderByLineChange(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (queue.size() > 1) {
            Node curr = queue.poll();
            if (curr == null) {
                System.out.println();
                queue.add(null);
                continue;
            }
            System.out.print(curr.data + " ");
            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }

    }

    public static void printLevelOrderByLineChange1(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                Node curr = queue.poll();
                System.out.print(curr.data + " ");
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            System.out.println();
        }
    }

    public static int treesize(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            count++;
            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
        return count;
    }

    public static int getSize(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + getSize(root.left) + getSize(root.right);
    }

    public static int maxValue(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        return Math.max(root.data, Math.max(maxValue(root.left), maxValue(root.right)));
    }

    public static int maxValue2(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            max = Math.max(max, curr.data);
            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
        return max;
    }

    public static void leftView1(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                if (i == 0) {
                    System.out.print(curr.data + " ");
                }
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
    }

    public static void leftView(Node root, int level) {
        if (root == null) {
            return;
        }
        if (maxLevel < level) {
            System.out.print(root.data + " ");
            maxLevel = level;
        }
        leftView(root.left, level + 1);
        leftView(root.right, level + 1);
    }

    public static boolean isCsum(Node root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        int sum = 0;
        if (root.left != null) {
            sum += root.left.data;
        }
        if (root.right != null) {
            sum += root.right.data;
        }
        return (root.data == sum) && isCsum(root.left) && isCsum(root.right);
    }
}
