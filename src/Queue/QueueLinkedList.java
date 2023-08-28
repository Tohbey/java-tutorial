package Queue;

import Linked_List.SingleLinkedList.SingleLinkedList;

public class QueueLinkedList {
    SingleLinkedList singleLinkedList;

    public QueueLinkedList(){
        singleLinkedList = new SingleLinkedList();
    }

    public void enqueue(int value){
        if (isEmpty()){
            singleLinkedList.createSinglyLinkedList(value);
        }else{
            singleLinkedList.insertInLinkedList(value,singleLinkedList.size);
        }
    }

    public int dequeue(){
        int result;
        if(isEmpty()){
            result = -1;
            System.out.println("Queue is empty");
        }else{
            result = singleLinkedList.head.value;
            singleLinkedList.deletionOfNode(0);
        }
        return result;
    }

    public boolean isEmpty(){
        return singleLinkedList.head == null;
    }

    public int peek(){
        int result;
        if(isEmpty()){
            result = -1;
            System.out.println("Queue is empty");
        }else{
            result = singleLinkedList.head.value;
        }
        return result;
    }

    public void delete(){
        singleLinkedList.deleteSingleLinkedList();
    }
}
