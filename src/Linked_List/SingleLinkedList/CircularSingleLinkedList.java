package Linked_List.SingleLinkedList;

public class CircularSingleLinkedList {
    public Node head;
    public Node tail;
    public int size;


    public Node createCSLL(int value){
        head = new Node();
        Node node = new Node(value);
        node.next = node;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    public void insertInLinkedList(int value, int location){
        Node node = new Node(value);
        if(head == null){
            createCSLL(value);
        } else if (location == 0) {
            node.next = head;
            head = node;
            tail.next = node;
        } else if (location >= size) {
            tail.next = node;
            tail = node;
            tail.next = head;
        }else{
            Node tempNode = head;
            int i = 0;
            while (i < location -1){
                tempNode = tempNode.next;
                i++;
            }
            Node nextNode = tempNode.next;
            tempNode.next = node;
            node.next = nextNode;
        }

        size++;
    }

    public void traversalSinglyLinkedList(){
        if(head == null){
            System.out.println("Single linked list does not exist");
        }else {
            Node tempNode = head;
            int i = 0;
            while (i<size){
                System.out.print(tempNode.value);
                if(i !=size-1){
                    System.out.print(" -> ");
                }
                tempNode = tempNode.next;
                i++;
            }
        }
        System.out.println("\n");
    }

    public boolean SearchInSinglyLinkedList(int nodeValue){
        if(head != null){
            Node tempNode = head;
            int i =0;
            while (i < size){
                if(tempNode.value == nodeValue){
                    System.out.println("Found at location "+i);
                    return true;
                }
                tempNode = tempNode.next;
                i++;
            }
        }
        System.out.println("Node not found");
        return false;
    }

    public void deletionOfNode(int location){
        if(head == null){
            System.out.println("Single linked list does not exist");
            return;
        }else if(location == 0){
            head = head.next;
            tail.next = head;
            size--;
            if(size ==0){
                tail = null;
            }
        }else if(location >= size){
            int i = 0;
            Node tempNode = head;
            while (i< size-1){
                tempNode = tempNode.next;
                i++;
            }
            if(tempNode == head){
                head.next = null;
                tail = head = null;
                size--;
                return;
            }
            tempNode.next = null;
            tail = tempNode;
            size--;
        }else {
            Node tempNode = head;
            int i = 0;
            while (i < location-1){
                tempNode = tempNode.next;
                i++;
            }
            tempNode.next = tempNode.next.next;
            size--;
        }
    }

    public void deleteSingleLinkedList(){
        if(head == null){
            System.out.println("Single linked list does not exist");
        }else {
            head = null;
            tail.next = null;
            System.out.println("Circular Single Linked List deleted");
        }
    }
}
