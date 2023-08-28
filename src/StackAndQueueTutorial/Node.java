package StackAndQueueTutorial;

public class Node {
    public int value;
    public Node next;

    public Node(int value){
        this.value = value;
    }

    public Node(int value, Node next){
        this.next = next;
        this.value = value;
    }

    public Node(){}
}
