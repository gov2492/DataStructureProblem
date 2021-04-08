package LinkedList.singly;

public class CLL {

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = head;
        //  traverse(head);
        traverse(DeleteFromKTH(head,2));
    }
    public static Node DeleteFromKTH(Node head,int k){
        if(k==1){
            head.data=head.next.data;
            head.next=head.next.next;
            return head;
        }
        Node curr=head;
        for(int i=0;i<k-2;i++){
            curr=curr.next;
        }
        curr.next=curr.next.next;
        return head;
    }
    public static Node deleteFromStartEffi(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return null;
        }
        head.data=head.next.data;
        head.next=head.next.next;
        return head;
    }
    public static Node deleteFromStart(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return null;
        }
        Node curr = head;
        while (curr.next != head) {
            curr = curr.next;
        }
        curr.next = head.next;
        return curr.next;
    }

    public static void traverse(Node head) {
        Node curr = head;
//        while(!curr.next.equals(head)){
//            System.out.println(curr.data);
//            curr=curr.next;
//        }
//        System.out.println(curr.data);

        do {
            System.out.println(curr.data);
            curr = curr.next;
        } while (!curr.equals(head));
    }

    //O(n)
    public static Node insertAtbegin(Node head, int data) {
        Node node = new Node(data);
        if (head == null) {
            node.next = node;
            return node;
        } else {
            Node curr = head;
            while (curr.next != head) {
                curr = curr.next;
            }
            curr.next = node;
            node.next = head;
            return node;
        }
    }

    //O(1)
    public static Node insertAtStart(Node head, int data) {
        Node temp = new Node(data);
        if (head == null) {
            temp.next = temp;
            return temp;
        } else {
            Node next = head.next;
            head.next = temp;
            temp.next = next;
            int tep = head.data;
            head.data = temp.data;
            temp.data = tep;
            return head;
        }

    }

    public static Node insertAtEnd(Node head, int data) {
        Node temp = new Node(data);
        if (head == null) {
            temp.next = temp;
            return temp;
        } else {
            Node curr = head;
            while (curr.next != head) {
                curr = curr.next;
            }
            curr.next = temp;
            temp.next = head;
        }
        return head;
    }

    public static Node insertAtLast(Node head, int data) {
        Node temp = new Node(data);
        if (head == null) {
            temp.next = temp;
            return temp;
        } else {
            Node next = head.next;
            head.next = temp;
            temp.next = next;
            int tep = head.data;
            head.data = temp.data;
            temp.data = tep;
            return head.next;
        }

    }
}
