package StackAndQueueTutorial;

public class StackMin {
    int[] minValue;
    int currentMin;
    int size;
    int topOfStack;

    int[] stack;
    public StackMin(int size) {
        stack = new int[size];
        minValue = new int[size];
        currentMin = 0;
        topOfStack = -1;
    }

    public int min() {
        return minValue[currentMin];
    }

    public void push(int value) {
        if(isFull()){
            System.out.println("Stack is full");
        }else{
            if(isEmpty()){
                currentMin = 0;
                minValue[currentMin] = value;
            }else{
                if(minValue[currentMin] < value){
                    currentMin++;
                    minValue[currentMin] = value;
                }
            }
            stack[topOfStack+1]= value;
            topOfStack++;
        }
    }

    public boolean isFull(){
        return  topOfStack == stack.length - 1;
    }

    public boolean isEmpty(){
        return topOfStack == -1;
    }

    public int pop() {
        if(isEmpty()){
            System.out.println("Stack is empty");
            return 0;
        }else{
            int topStack = stack[topOfStack];
            if(topStack == minValue[currentMin]){
                currentMin--;
            }
            topOfStack--;
            return topStack;
        }
    }
}
