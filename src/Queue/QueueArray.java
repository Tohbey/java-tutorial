package Queue;

public class QueueArray {
    int[] arr;
    int beginningOfQueue;
    int topOfQueue;

    public QueueArray(int size){
        this.arr = new int[size];
        topOfQueue = -1;
        beginningOfQueue = -1;

        System.out.println("The queue is created with size "+size);
    }

    public boolean isEmpty(){
        return topOfQueue == -1;
    }

    public boolean isFull(){
        return  topOfQueue == arr.length -1;
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
            topOfQueue++;
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
            beginningOfQueue++;
            if(beginningOfQueue > topOfQueue){
                beginningOfQueue = -1;
                topOfQueue = -1;
            }
        }
        return result;
    }

    public int peek(){
        int result;
        if(isEmpty()){
            System.out.println("Queue is empty");
            result = -1;
        }else{
            result = arr[beginningOfQueue];
        }
        return result;
    }

    public void deleteQueue(){
        arr = null;
        topOfQueue = beginningOfQueue = -1;
        System.out.println("Queue is successfully deleted");
    }
}
