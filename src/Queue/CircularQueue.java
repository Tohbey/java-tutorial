package Queue;

public class CircularQueue {
    int[] arr;
    int topOfQueue;
    int beginningOfQueue;
    int size;

    public CircularQueue(int size){
        this.arr = new int[size];
        this.size = size;
        this.topOfQueue = this.beginningOfQueue = -1;
        System.out.println("The circular queue is created with size "+size);
    }

    public boolean isEmpty(){
        return topOfQueue == -1;
    }

    public boolean isFull(){
        if(topOfQueue+1 == beginningOfQueue){
            return true;
        }else if(beginningOfQueue == 0 && topOfQueue+1==size){
            return true;
        }else {
            return false;
        }
    }

    public void enqueue(int value){
        if(isFull()){
            System.out.println("Queue is full");
        }else if(isEmpty()){
            beginningOfQueue = 0;
            topOfQueue++;
            arr[topOfQueue] = value;
            System.out.println("The value is successfully inserted into the queue "+value);
        }else{
            if(topOfQueue+1 == size){
                topOfQueue = 0;
            }else{
                topOfQueue++;
            }
            arr[topOfQueue] = value;
            System.out.println("The value is successfully inserted into the queue "+value);
        }
    }

    public int dequeue(){
        int result;
        if(isEmpty()){
            System.out.println("Queue is empty");
            result = -1;
        }else{
            result = arr[beginningOfQueue];
            arr[beginningOfQueue] = Integer.MIN_VALUE;
            if(beginningOfQueue == topOfQueue){
                beginningOfQueue = topOfQueue = -1;
            } else if (beginningOfQueue+1 == size) {
                beginningOfQueue = 0;
            }else{
                beginningOfQueue++;
            }
        }

        return result;
    }

    public int peek(){
        int result;
        if(isEmpty()){
            result = -1;
        }else {
            result = arr[beginningOfQueue];
        }
        return  result;
    }
}
