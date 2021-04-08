package LinkedList.singly;

public class Test {

    public static void main(String[] args) {
        Node headA = new Node(20);
        Node temp1 = new Node(20);
        Node temp2 = new Node(20);
        headA.next = temp1;
        temp1.next = temp2;
        traverse(removeDuplicatesFormSorted(headA));
        //  System.out.println(reverseLi(headA));
        // printNthNodeFromEnd(headA, 1);
//        Node headB = new Node(1);
//        Node temp3 = new Node(0);
//        headB.next = temp3;
//        temp3.next = temp1;
        // System.out.println(getIntersectionNode(headA, headB).data);

//        traverse(reverse(head));
//        ;
        // traverseRecursive(insertAtPosition(head, 40, 4));
        //  System.out.println(getDecimalValue(head));
    }

    public static Node removeDuplicatesFormSorted(Node head) {
        Node curr = head;
        while (curr != null && curr.next!=null) {
            if (curr.data == curr.next.data) {
                curr.next = curr.next.next;
            }
            else {
                curr = curr.next;
            }
        }
        return head;
    }

    public static Node reverseNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node rest_head = reverseNode(head.next);
        Node rest_tail = head.next;
        rest_tail.next = head;
        head.next = null;
        return rest_head;
    }

    public static Node reverseNode(Node curr, Node prev) {
        if (curr == null) {
            return prev;
        }
        Node next = curr.next;
        curr.next = prev;
        return reverseNode(next, curr);
    }

    public static Node reverseLi(Node head) {
        if (head == null) {
            return null;
        }
        Node nex;
        Node prev = null;
        Node temp = head;
        while (temp != null) {
            nex = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nex;
        }
        return prev;
    }

    public static void printNthNodeFromEnd(Node head, int n) {
        if (head == null) {
            return;
        }
        Node second = head;
        Node first = head;
        for (int i = 0; i < n - 1; i++) {
            first = first.next;
        }
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        System.out.println(second.data);
    }

    public static int middleNode(Node head) {
        if (head == null) {
            return 0;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    public static Node insertInSortedOrder(Node head, int data) {
        Node node = new Node(data);
        if (head == null) {
            return node;
        }
        if (head.data > data) {
            node.next = head;
            return node;
        }
        Node curr = head;
        while (curr.next != null) {
            if (curr.next.data > data) {
                break;
            }
            curr = curr.next;
        }
        node.next = curr.next;
        curr.next = node;
        return head;
    }

    public static Node getIntersectionNode(Node headA, Node headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Node a = headA;
        Node b = headB;
        int sa = getSize(headA);
        int sb = getSize(headB);
        if (sa > sb) {
            int k = sa - sb;
            while (k > 0) {
                a = a.next;
                k--;
            }
        } else if (sb > sa) {
            int k = sa - sb;
            while (k > 0) {
                b = b.next;
                k--;
            }
        }

        while (a != null && b != null) {
            if (a.equals(b)) {
                return a;
            } else {
                a = a.next;
                b = b.next;
            }
        }
        return null;
    }

    public static int getDecimalValue(Node head) {
        int num = 0, k = 0;
        Node temp = reverse(head);
        while (temp != null) {
            num = num + (temp.data) * (int) Math.pow(2, k);
            k++;
            temp = temp.next;
        }
        return num;
    }

    public static Node deleteGivenValue(Node head, int val) {
        Node pre = null;
        Node curr = head;
        while (curr != null) {
            if (curr.data != val) {
                if (pre == null) {
                    pre = curr;
                    head = pre;
                    curr = curr.next;
                } else {
                    pre.next = curr;
                    pre = curr;
                    curr = curr.next;
                }
            } else {
                if (curr.next == null) {
                    if (pre != null) {
                        pre.next = null;
                    }
                    head = pre;
                }

                curr = curr.next;
            }
        }
        return head;
    }

    public static Node reverse(Node head) {
        Node temp = head;
        Node prev = null;
        Node nex;
        while (temp != null) {
            nex = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nex;
        }
        return prev;

    }

    public static int search(Node head, int x) {
        if (head == null) {
            return -1;
        }
        if (head.data == x) {
            return 1;
        } else {
            int res = search(head.next, x);
            if (res == -1) {
                return -1;
            } else {
                return res + 1;
            }
        }
    }

    public static Node insertAtPosition(Node head, int data, int position) {
        Node temp = new Node(data);
        if (position == 1) {
            temp.next = head;
            return temp;
        }
        Node curr = head;
        for (int i = 1; i <= position - 2 && curr != null; i++) {
            curr = curr.next;
        }
        if (curr == null) {
            return head;
        }
        temp.next = curr.next;
        curr.next = temp;
        return head;

    }

    public static Node deleteAtBegin(Node head) {
        if (head == null) {
            return null;
        }
        head = head.next;
        return head;
    }

    public static Node deleteAtLast(Node head) {
        if (head == null) {
            return null;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    public static Node insertAtBegin(Node head, int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return head;
        }
        node.next = head;
        head = node;
        return head;
    }

    public static Node insertAtLast(Node head, int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return head;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        return head;
    }

    public static void traverse(Node head) {
        Node node = head;
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    public static void traverseRecursive(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.data);
        traverseRecursive(head.next);
    }

    public static int getSize(Node head) {
        int count = 0;
        if (head == null) {
            return count;
        }
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
