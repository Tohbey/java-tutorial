package StackAndQueueTutorial;

public class StackMinV2 {
    Node minNode;
    Node stack;

    public StackMinV2() {
        minNode = new Node();
        stack = new Node();
    }

    public int min() {
        return minNode.value;
    }

    public void push(int value) {
        if(minNode == null){
            minNode = new Node(value, minNode);
        } else if (minNode.value > value) {
            minNode = new Node(minNode.value, minNode);
        }else{
            minNode = new Node(value, minNode);
        }
        stack = new Node(value, stack);
    }

    public int pop() {
        minNode = minNode.next;
        int result = stack.value;
        stack = stack.next;

        return  result;
    }
}
