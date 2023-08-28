package StackAndQueueTutorial;


public class ThreeInOne{
    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public ThreeInOne(int stackSize) {
        stackCapacity = stackSize;
        values = new int[stackSize*numberOfStacks];
        sizes = new int[stackSize];
    }

    // isFull
    public boolean isFull(int stackNum) {
        if(sizes[stackNum] == stackCapacity) {
            return true;
        }else{
            return false;
        }
    }

    // isEmpty
    public boolean isEmpty(int stackNum) {
        if(sizes[stackNum] == 0) {
            return true;
        }else{
            return false;
        }
    }

     // indexOfTop - this is helper method for push, pop and peek methods
     private int indexOfTop(int stackNum) {
        int result;
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];
        result = offset + size - 1;
        return result;
     }

        // push
     public void push(int stackNum, int value) {
        if(isFull(stackNum)){
            System.out.println("Stack is full");
        }else{
            sizes[stackNum]++;
            values[indexOfTop(stackNum)] = value;
        }
     }

        // pop
     public int pop(int stackNum) {
        // TODO
         int result;
         if(isEmpty(stackNum)){
             System.out.println("Stack is full");
             result = -1;
         }else{
             int topIndex = indexOfTop(stackNum);
             result = values[topIndex];
             values[topIndex] = Integer.MIN_VALUE;
             sizes[stackNum]--;
         }
         return result;
     }

        // peek
     public int peek(int stackNum) {
         // TODO
         int result;
         if(isEmpty(stackNum)){
             System.out.println("Stack is full");
             result = -1;
         }else{
             int topIndex = indexOfTop(stackNum);
             result = values[topIndex];
         }
         return result;
     }
}
