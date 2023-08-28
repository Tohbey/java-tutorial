package Array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

public class ArrayQuestions {

    public void missingNumber(int[] intArray){
        Arrays.sort(intArray);
        int smallest = intArray[0];
        System.out.println("smallest "+smallest);
        for(int i=0; i<intArray.length; i++){
            if(intArray[i] != smallest+i){
                int missing = smallest+i;
                System.out.println("missing number is "+missing);
                return;
            }
        }
        System.out.println("no missing number");
    }


    public void missingNumberV2(int[] intArray){
        Arrays.sort(intArray);
        int sumOfElement = 0;
        int sum2 = 0;
        for(int i :intArray){
            sumOfElement += i;
        }

        sum2 = intArray[intArray.length -1]*(intArray[intArray.length -1] + 1)/2;

        int missing = sum2 - sumOfElement;
        if(missing > 0){
            System.out.println("missing number is "+missing);
        }else{
            System.out.println("no missing number");
        }
    }

    public int[] twoSums(int[] nums, int target){
        Arrays.sort(nums);
        var i = 0;
        var j = 1;
        while (j < nums.length){
            if(nums[i] + nums[j] == target){
                return new int[]{i, j};
            }
            i++;
            j++;
        }
        throw new IllegalArgumentException("No solution found");
    }

    public int searchArray(int[] intArray, int valueToSearch){
        Arrays.sort(intArray);

        if(valueToSearch == intArray[0]){
            return 0;
        }

        for(int i=1; i<intArray.length;i++){
            if(intArray[i] == valueToSearch){
                System.out.println("Value is found a the index of "+ i);
                return i;
            }
        }
        throw new IllegalArgumentException("No solution found");
    }

    public int maxProduct(int[] intArray){
       int max = 0;
       String pairs = "";
       int i=0;
       int j=1;
       while (j < intArray.length){
           int currentMax = 0;
           currentMax = intArray[i] * intArray[j];
           if(currentMax > max){
               max = currentMax;
               pairs = Integer.toString(intArray[i]) +","+Integer.toString(intArray[j]);
           }
           i++;
           j++;
       }
        System.out.println("Pairs "+pairs);
        return max;
    }

    public boolean isUnique(int[] intArray){
        Arrays.sort(intArray);
        int i=0;
        int j=1;
        while (j < intArray.length){
            if(intArray[i] == intArray[j]){
                System.out.println("Is not Unique");
                return false;
            }
            i++;
            j++;
        }
        return true;
    }


    public boolean permutation(int[] array1, int[] array2){
        int sumOfArray1 = 0;
        int sumOfArray2 = 0;
        int mul1 =1;
        int mul2 = 1;
        if(array1.length != array2.length){
            return false;
        }
        for(int i = 0;i<array1.length;i++){
            sumOfArray1+=array1[i];
            sumOfArray2 += array2[i];
            mul1*=array1[i];
            mul2*=array2[i];
        }

        if(sumOfArray1 == sumOfArray2 && mul1== mul2){
            return true;
        }
        return false;
    }

    public boolean rotateMatrix(int[][] matrix){
        if (matrix.length == 0 || matrix.length != matrix[0].length){
            return false;
        }
        int n = matrix.length;
        for(int layer = 0; layer < n/2; layer++){
            int first = layer;
            int last = n-1-layer;
            for(int i=first;i<last;i++){
                int offset = i - first;
                int top = matrix[first][i];
                matrix[first][i] = matrix[last - offset][first];
                matrix[last-offset][first] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[i][last];
                matrix[i][last] = top;
            }
        }

        return true;
    }

    public int sumDiagonal(int[][] arr){
        int i = 0;
        int sum = 0;
        while (i<arr.length){
            sum += arr[i][i];
            i++;
        }

        return sum;
    }

    public String firstSecond(Integer[] myArray){
        Arrays.sort(myArray, Collections.reverseOrder());
        int second = 0;
        int first = myArray[0];
        if(myArray.length > 1){
            int i=0;
            while(i < myArray.length){
                if(myArray[i] != first){
                    second = myArray[i];
                    break;
                }
                i++;
            }

            return first+" "+second;
        }
        return "first "+myArray[0];
    }


    public String pairSum(int[] myArray, int sum){
        String result = "";
        for(int i = 0;i<myArray.length;i++){
            for(int j=i+1;j<myArray.length;j++){
                int currentSum = myArray[i] + myArray[j];
                if(currentSum == sum){
                    result += i+":"+j;
                }
            }
        }
        return result;
    }
}
