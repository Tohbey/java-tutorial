package Array;

import java.util.Arrays;

public class ArrayTutorials {
    //initializing an array with a fixed size.
    int[] intArray = new int[3];
    int[] sArray = {1, 2, 3 ,4 };

    int[] arr = null;
    int[][] int2DArray = null;
    public String arrayOutput(int[] a){
        return Arrays.toString(a);
    }

    public ArrayTutorials(int sizeOfArray){
        arr = new int[sizeOfArray];
        Arrays.fill(arr, Integer.MIN_VALUE);
    }

    public ArrayTutorials(int sizeCol, int sizeRow){
        int2DArray = new int[sizeRow][sizeCol];
        for(int i=0; i< sizeRow; i++){
            Arrays.fill(int2DArray[i], Integer.MIN_VALUE);
        }
    }

    public void insert(int location, int value){
        try {
            if(arr[location] == Integer.MIN_VALUE){
                arr[location] = value;
                System.out.println("Succesfully inserted");
            }else{
                System.out.println("This cell is already occupied");
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid index to access array");
        }
    }

    public void insert(int row, int col, int value){
        try {
            if(int2DArray[row][col] == Integer.MIN_VALUE){
                int2DArray[row][col] = value;
                System.out.println("Succesfully inserted");
            }else{
                System.out.println("This cell is already occupied");
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid index to access array");
        }
    }

    public void accessCell(int row, int col){
        System.out.println("accessing row "+row+", col "+col);
        try{
            System.out.println("Cell value is: "+int2DArray[row][col]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid index to access array");
        }
    }

    public void traverseArray(){
        for (int j : arr) {
            System.out.print(j + ", ");
        }
    }

    public void traverse2DArray(){
        for(int row =0; row< int2DArray.length; row++){
            for(int col=0;col< int2DArray[0].length; col++){
                System.out.println(int2DArray[row][col] +" ");
            }
            System.out.println();
        }
    }

    public void searchIn2DArray(int valueToSearch){
        for (int row=0;row<int2DArray.length;row++){
            for(int col=0;col< int2DArray[0].length; col++){
                if(int2DArray[row][col] == valueToSearch){
                    System.out.println("Value is found at row "+row+", col"+col);
                    return;
                }
            }
        }
        System.out.println("Value is not found "+valueToSearch);
    }

    public void searchInArray(int valueToSearch){
        for (int i=0;i<arr.length;i++){
            if(arr[i] == valueToSearch){
                System.out.println("Value is found at "+i);
                return;
            }
        }
        System.out.println("Value is not found "+valueToSearch);
    }

    public void deleteValue(int valueToDelete){
        try {
            arr[valueToDelete] = Integer.MIN_VALUE;
            System.out.println("The value has been deleted");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid index to access array");
        }
    }

    public void deleteValue(int row, int col){
        try {
            int2DArray[row][col] = Integer.MIN_VALUE;
            System.out.println("The value has been deleted");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid index to access array");
        }
    }
}
