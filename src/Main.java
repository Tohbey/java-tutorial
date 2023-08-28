import Array.ArrayQuestions;
import Inheritance.Car;
import Interface.PigInter;
import LeetCode.Easy;
import Polymorphism.*;
import Recursion.RecursionTutorials;
import abstraction.PigAbs;

import java.math.BigDecimal;
import java.text.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date postDate = dateFormat.parse("2023-07-01");

        LocalDate postLocalDate =  postDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        Date today = new Date();
        LocalDate todayLocalDate =  today.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();


        Date endDate = dateFormat.parse("2023-07-10");
        LocalDate endLocalDate =  endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        System.out.println(postLocalDate);
        System.out.println(todayLocalDate);

        if((postLocalDate.isEqual(todayLocalDate) || postLocalDate.isAfter(todayLocalDate))
                && (endLocalDate.isEqual(todayLocalDate) || todayLocalDate.isBefore(endLocalDate))){
            System.out.println(true);
        } else{
            System.out.println(false);
        }
//        System.out.println("Hello world!");
//        Car myCar = new Car();
//
//        myCar.honk();
//        System.out.println(myCar.brand+" "+myCar.modelName);
//
//        Animal myAnimal = new Animal();
//        Pig myPig = new Pig();
//        Dog myDog = new Dog();
//
//        myAnimal.animalSound();
//        myPig.animalSound();
//        myDog.animalSound();
//
////      Abstraction
//        PigAbs pigAbs = new PigAbs();
//        pigAbs.animalSound();
//        pigAbs.sleep();
//
////      Interface
//        PigInter pigInter = new PigInter();
//        pigInter.animalSound();
//        pigInter.sleep();
//
////      Data structure
////      Array List
//        ArrayList<String> cars = new ArrayList<String>();
//        cars.add("Volvo");
//        cars.add("BMW");
//        cars.add("Ford");
//        cars.add("Mazda");
//        System.out.println(cars);
//
//        System.out.println(cars.get(0));
//        cars.set(0,"Toyota");
//        System.out.println(cars.get(0));
//
////      Linked list
//        LinkedList<String> cartoons = new LinkedList<String>();
//        cartoons.add("tom and jerry");
//        cartoons.add("Ben 10");
//        cartoons.add("pink and the brain");
//
////      hashMap
//        HashMap<String, String> capitalCities = new HashMap<String, String>();
//
//        // Add keys and values (Country, City)
//        capitalCities.put("England", "London");
//        capitalCities.put("Germany", "Berlin");
//        capitalCities.put("Norway", "Oslo");
//        capitalCities.put("USA", "Washington DC");
//        System.out.println(capitalCities);
//
////      iterator is an object that can be used to loop through collections
//        Iterator<String> carsList = cars.iterator();
//        System.out.println(carsList.next());
//
//        while (carsList.hasNext()){
//            System.out.println(carsList.next());
//        }
//
//
//        int result=equivalentArrays (new int [] {0,2,1,2}, new int [] {0,2,1,2,1});
//        System.out.println(result);
//        result=equivalentArrays (new int [] {3,1,2,0}, new int [] {0,2,1,0});
//        System.out.println(result);
//
//        int minNum = findMin(new int [] {0,0,0,0,0});
//        int maxNum = findMax(new int [] {0,2,1,2,1});
//        System.out.println("Min number "+minNum);
//        System.out.println("Max number "+maxNum);
//
//
//        System.out.println(String.format("%s%s","fafowora@gmail.com", "WALL1#"));
//
//        String error = "{\n" +
//                "  \"code\" : \"error\",\n" +
//                "  \"message\" : \"An error occurred, please try again\",\n" +
//                "}";
//        String splitString = error.split(":")[1].split(",",3)[0].replace("\"", "")+error.split(":")[1].split(",",3)[1].replace("\"", "");
//        String code = error.split(":")[2].split(",")[0].replace("\"", "");
//
//        String[] errorMessages = new String[]{splitString, code};
//        System.out.println(errorMessages[1]);
//
//        System.out.println(50 > 20);
//        System.out.println(50 < 20);
//
//        RecursionTutorials recursionTutorials = new RecursionTutorials();
//        System.out.println(recursionTutorials.factorial(-2));
//        System.out.println(recursionTutorials.sumOfDigits(1119));
//        System.out.println(recursionTutorials.power(2, 3));
//        System.out.println(recursionTutorials.decimalToBinary(10));
//
//        int arr[] = {1, 2, 3 ,4 ,5};
//        System.out.println(recursionTutorials.productOfArray(arr,arr.length));
//        System.out.println(recursionTutorials.recursiveRange(6));
//        System.out.println(recursionTutorials.reverse("java"));
//
//        int arr1[] = {1, 2, 3 ,4 ,5, 6,7,9,10};
//        ArrayQuestions arrayQuestions = new ArrayQuestions();
//        arrayQuestions.missingNumber(arr1);
//        arrayQuestions.missingNumberV2(arr1);
//        arrayQuestions.maxProduct(new int[]{10, 20, 30, 40, 50});
//        arrayQuestions.isUnique(new int[]{10, 20, 30, 40, 50});
//
//        System.out.println(new Date().toLocaleString());
//
//        BigDecimal amount = BigDecimal.valueOf(1002340);
//
//        System.out.println(getCurrencyDisplayAmount(amount));
    }

    private static String[] getDateString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String str[] = dateFormat.format(date).split("-");
        return str;
    }

    public static String getCurrencyDisplayAmount(BigDecimal amount){
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setCurrencySymbol("NGN");
        NumberFormat currencyFormatter = new DecimalFormat("¤#,##0.00", symbols);
        return currencyFormatter.format(amount);
    }

    public static int equivalentArrays(int a1[], int a2[]){
        if(a1 == null || a1.length == 0 || a2==null || a2.length==0){
            return 0;
        }

        for(int i=0;i<a1.length;i++){
            for(int j=0;j<a2.length;j++){
                if(a1[i] == a2[j]){
                    return 1;
                }
            }
        }
        return 0;
    }

    public static int findMin(int a[]){
        int minNum = a[0];
        if(a.length > 1){
            for(int i=1;i<a.length;i++){
                if(minNum < a[i]){
                    minNum = a[i];
                }
            }
        }

        return minNum;
    }

    public static int findMax(int a[]){
        int maxNum = a[0];
        if(a.length > 1){
            for(int i=1;i<a.length;i++){
                if(a[i] > maxNum){
                    maxNum = a[i];
                }
            }
        }

        return maxNum;
    }
}
