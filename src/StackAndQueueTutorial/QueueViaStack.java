package StackAndQueueTutorial;


import java.util.Stack;

public class QueueViaStack {
    Stack<Integer> stackNewest, stackOldest;

    public QueueViaStack(){
        stackNewest = new Stack<Integer>();
        stackOldest = new Stack<Integer>();
    }

    public int size(){
        return stackNewest.size() + stackOldest.size();
    }

    public void enqueue(int value){
        stackNewest.push(value);
    }

    public int dequeue(){
        shiftStacks();
        return stackOldest.pop();
    }

    public int peek(){
        shiftStacks();
        return stackOldest.peek();
    }

    private void shiftStacks(){
        if(stackOldest.isEmpty()){
            while ((!stackNewest.isEmpty())){
                int popOut = stackNewest.pop();
                stackOldest.push(popOut);
            }
        }
    }
}
