package StackAndQueueTutorial;

public class SetOfStacks {
    private int capacity;
    public StackNode top;
    public StackNode bottom;
    public int size = 0;

    public SetOfStacks(int capacity){
        this.capacity = capacity;
    }

    public boolean isFull(){
        return capacity == size;
    }

    public void join(StackNode above, StackNode below){
        if(below != null){
            below.above = above;
        }

        if(above != null){
            above.below = below;
        }
    }


}
