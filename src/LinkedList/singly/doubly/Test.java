package LinkedList.singly.doubly;

public class Test {

    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);
        head.next = temp1;
        temp1.prev = head;
        temp1.next = temp2;
        temp2.prev = temp1;
        traverse(reverse(head));

    }
    public static void traverse(Node head) {
        Node node = head;
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }
    public static Node insertAtBegining(Node head, int data) {
        Node temp = new Node(data);
        if (head == null) {
            return temp;
        } else {
            temp.next = head;
            head.prev = temp;
            return temp;
        }
    }

    public static Node insertAtLast(Node head, int data) {
        Node temp = new Node(data);
        if (head == null) {
            return temp;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = temp;
            temp.prev = curr;
            return head;
        }
    }

    public static Node reverse(Node head){
        Node pre = null;
        Node temp=head;
        while(temp!=null){
           pre=temp.prev;
           temp.prev=temp.next;
           temp.next=pre;
           temp=temp.prev;
        }
        return pre.prev;
    }
}
