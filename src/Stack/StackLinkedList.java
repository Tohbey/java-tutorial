package Stack;

import Linked_List.SingleLinkedList.SingleLinkedList;

public class StackLinkedList {
    SingleLinkedList singleLinkedList;

    public StackLinkedList(){
        singleLinkedList = new SingleLinkedList();
    }

    public void push(int value){
        this.singleLinkedList.insertInLinkedList(value, 0);
        System.out.println("Inserted in stack "+value);
    }

    public boolean isEmpty(){
        return singleLinkedList.head == null;
    }

    public int pop(){
        int result = -1;
        if(isEmpty()){
            System.out.println("Stack is empty");
        }else{
            result = singleLinkedList.head.value;
            singleLinkedList.deletionOfNode(0);
        }
        return result;
    }

    public int peek(){
        int result = -1;
        if(isEmpty()){
            System.out.println("Stack is empty");
        }else{
            result = singleLinkedList.head.value;
        }
        return result;
    }

    public void delete(){
        singleLinkedList.deleteSingleLinkedList();
    }
}
