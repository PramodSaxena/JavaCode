// Reorder Linked List
public class ReorderedLinkedList {

    static Node head; // head of the list

    static class Node {

        int data;
        Node next;

        // Constructor to create a new node
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    public void reorderList(Node head) {
        if(head.next == null)return;
        Node slow = head, fast = head, prevSlow = slow;
        //get hold of mid of linked list
        while(fast != null &&  fast.next != null){
            prevSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prevSlow.next = null;// make it new lined list
        Node firstHlfHead = head;
        Node secondHlfHead = reverse(slow);
        while(firstHlfHead != null && secondHlfHead != null){

            Node nextFirstHlfNode = firstHlfHead.next;
            firstHlfHead.next = secondHlfHead;
            firstHlfHead = nextFirstHlfNode;
            Node nextSecondHlfNode = secondHlfHead.next;
            secondHlfHead.next = (nextFirstHlfNode != null) ? nextFirstHlfNode : nextSecondHlfNode;
            secondHlfHead = nextSecondHlfNode;
        }
    }
    private Node reverse(Node head){
        Node curr = head, prev = null;
        while(curr != null){
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    void printlist(Node node)
    {
        if (node == null) {
            return;
        }
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        ReorderedLinkedList list = new ReorderedLinkedList();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);

        list.printlist(head); // print original list

        list.reorderList(head); // rearrange list as per ques
        System.out.println("");
        list.printlist(head); // print original list


    }
}
