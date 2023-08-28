package Stack;

public class StackArray {
    int[] arr;
    int topOfStack;

    public StackArray(int size){
        this.arr = new int[size];
        this.topOfStack = -1;

        System.out.println("The stack is created with size "+size);
    }

    public boolean isEmpty(){
        return topOfStack == -1;
    }

    public boolean isFull(){
        return  topOfStack == arr.length - 1;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        return arr[topOfStack];
    }

    public void push(int value){
        if(isFull()){
            System.out.println("Stack is full");
        }else{
            arr[topOfStack + 1] = value;
            topOfStack++;
            System.out.println("The value is successfully inserted into the stack "+value);
        }
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return 0;
        }else{
            int topStack = arr[topOfStack];
            topOfStack--;
            return topStack;
        }
    }

    public void deleteStack(){
        arr = null;
        topOfStack =  -1;
        System.out.println("Stack is successfully deleted");
    }

}
