package LeetCode;

import java.util.*;

public class Easy {
    public boolean detectCapitalUse(String word) {
        if(word.length() == 0 || word.length() == 1) return true;

        if(Character.isUpperCase(word.charAt(0))){
            boolean isFirstCharacter = Character.isUpperCase(word.charAt(1));
            for(int i = 2; i < word.length(); i++){
                boolean currentCharState = Character.isUpperCase(word.charAt(i));
                if(currentCharState != isFirstCharacter) return false;
            }
        }else{
            for(int i = 1; i < word.length(); i++){
                if(Character.isUpperCase(word.charAt(i))) return false;
            }
        }
        return true;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target - nums[i])){
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                break;
            }
            map.put(nums[i],i);
        }
        return result;
    }

    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }else{
            String s = String.valueOf(x);
            int j = s.length() -1;
            for(int i = 0; i<s.length();i++){
                if(s.charAt(i) != s.charAt(j-i)){
                    return false;
                }
            }
        }
        return true;
    }

    public int romanToInt(String s) {
        int result = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);

        int i = 0;

        if(s.length() == 1){
            return hashMap.get(s.charAt(0));
        }

        while (i < s.length()){
            if (s.charAt(i) == 'I'){
                if (i+1 != s.length()){
                    if (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X'){
                        result -= 1;
                    } else {
                        result+=1;
                    }
                }
            }
            else if (s.charAt(i) == 'X'){
                if (i+1 != s.length()){
                    if (s.charAt(i+1) == 'L' || s.charAt(i+1) =='C'){
                        result -= hashMap.get(s.charAt(i));
                    } else {
                        result+=hashMap.get(s.charAt(i));
                    }
                }
            }
            else if (s.charAt(i) == 'C'){
                if (i+1 != s.length()){
                    if (s.charAt(i+1) == 'D' || s.charAt(i+1) =='M'){
                        result -= hashMap.get(s.charAt(i));
                    } else {
                        result+=hashMap.get(s.charAt(i));
                    }
                }
            }else{
                result+=hashMap.get(s.charAt(i));
            }

            i++;
        }
        return result;
    }

    public boolean isValid(String s){
        // Create a new stack to store the characters.
        Stack<Character> stack = new Stack<>();
        // convert string into char array and access the characters using for each loop.
        for(char ch: s.toCharArray())
        {
            // check ch
            switch (ch) {
                // open bracket then push it in stack.
                // close bracket then pop the item and compare.
                case '(':
                case '{':
                case '[':
                    stack.push(ch);
                    break;
                case ')':
                    // if the stack is empty then it means string have no open bracket.
                    // hence it is invalid.
                    if(stack.isEmpty() || stack.pop() != '('){
                        return false;
                    }
                    break;
                case '}':
                    if(stack.isEmpty() || stack.pop() != '{'){
                        return false;
                    }
                    break;
                case ']':
                    if(stack.isEmpty() || stack.pop() != '['){
                        return false;
                    }
                    break;
            }
        }
        // After the loop we have to check one more condition.
        // return true only if the stack is empty.
        // if stack is not empty that means we have unused brackets.
        if(stack.isEmpty())
            return true;
        else
            return false;
    }

    public int[] plusOne(int[] digits){
        for(int i = digits.length-1; i>=0;i++){
            if(digits[i] == 9){
                digits[i] = 0;
            }else{
                digits[i] +=1;
                return  digits;
            }
        }
        int[] arr = new int[digits.length + 1];
        arr[0] = 1;
        return arr;
    }

    public int removeElement(int[] nums, int val) {
        int c = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[c] = nums[i];
                c++;
            }
        }

        return c;
    }

    public int removeDuplicates(int[] nums) {
        Set<Integer> realNums = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!realNums.contains(nums[i])){
                realNums.add(nums[i]);
            }
        }

        return realNums.size();
    }

    public boolean OneAway(String s, String t){
        if(s==null || t==null){
            return false;
        }

        int m = s.length();
        int n = t.length();

        if(Math.abs(m - n) > 1){
            return false;
        }

        int i = 0;
        int j = 0;
        int count =0;

        while(i<m && j< n){
            if(s.charAt(i) == t.charAt(i)){
                i++;
                j++;
            }else{
                count++;
                if(count> 1){
                    return false;
                }

                if(m>n){
                    i++;
                }else if(m<n){
                    j++;
                }else{
                    i++;
                    j++;
                }
            }
        }

        if(i<m||j<n){
            count++;
        }

        if(count == 1)
            return true;

        return false;
    }

    public boolean isUnique(String a){
        HashMap<Character, Integer>  hashMap = new HashMap<>();
        if(a.length() < 1){
            return true;
        }else{
            for(int i=0;i<a.length();i++){
                if(hashMap.containsKey(a.charAt(i))){
                    return false;
                }
                hashMap.put(a.charAt(i), 1);
            }
        }

        return false;
    }

    public String URLify(String a){
        StringBuilder urlify = new StringBuilder();
        if(!a.contains(" ")){
            return a;
        }else{
            a = a.stripTrailing();
            char[] ch = a.toCharArray();
            for(char c: ch){
                if(Character.isWhitespace(c)){
                    urlify.append("%20");
                }else{
                    urlify.append(c);
                }
            }
            return urlify.toString();
        }
    }

    public boolean permutation(String str1, String str2){
        // Get lengths of both strings
        int n1 = str1.length();
        int n2 = str2.length();

        // If length of both strings is not same,
        // then they cannot be Permutation
        if (n1 != n2)
            return false;
        char ch1[] = str1.toCharArray();
        char ch2[] = str2.toCharArray();

        // Sort both strings
        Arrays.sort(ch1);
        Arrays.sort(ch2);

        // Compare sorted strings
        for (int i = 0; i < n1; i++)
            if (ch1[i] != ch2[i])
                return false;

        return true;
    }

    public String addBinary(String a, String b){
        StringBuilder res = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while(i >= 0 || j >= 0){
            int sum = carry;
            if(i >= 0) sum += a.charAt(i--) - '0';
            if(j >= 0) sum += b.charAt(j--) - '0';
            carry = sum > 1 ? 1 : 0;
            res.append(sum % 2);
        }
        if(carry != 0) res.append(carry);
        return res.reverse().toString();
    }

    public int lengthOfLastWord(String s){
       s = s.stripTrailing();
       String[] words = s.split(" ");
       String lastWord = words[words.length - 1];

       return lastWord.length();
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = head;
        ListNode current = head.next;
        while (current != null){
            if(prev.val == current.val){
                prev.next = current.next;
                current = current.next;
            }else{
                prev = current;
                prev.next = current.next;
            }
        }

        return head;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n){
        int last = m + n - 1;
        while (m > 0 && n > 0){
            if(nums1[m-1]> nums2[n-1]){
                nums1[last] = nums1[m-1];
                m -=1;
            }else{
                nums1[last] =  nums2[n-1];
                n-=1;
            }
            last -= 1;
        }

        while (n > 0){
            nums1[last] = nums2[n-1];
            n -= 1;
            last -= 1;
        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        int i = 0;
        while (i < numRows){
            List<Integer> row = new ArrayList<>();
            int j = 0;
            while (j < i){
                if(j == 0 || j == i-1){
                    row.add(1);
                }else{
                    row.add(result.get(i-2).get(j) + result.get(i-2).get(j-1));
                }
                j++;
            }
            result.add(row);
            i++;
        }

        return result;
    }

    public boolean isPalindrome(String s) {
        s = s.stripTrailing();
        if (s.length() > 1) {
            s = s.replaceAll("[^a-z0-9]", "").toLowerCase();
            char[] sChar = s.toCharArray();
            int i = 0;
            int j = sChar.length - 1;
            while (i < j) {
                if (sChar[i] != sChar[j]) {
                    return false;
                }
                i++;
                j++;
            }
        }
        return true;
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;


        while (left <= right){
            int middle = (left + right )/2;

            if (nums[middle] == target){
                return middle;
            } else if (target > nums[middle]) {
                left = middle + 1;
            }else {
                right = middle -1;
            }
        }

        return left;
    }

    public int majorityElement(int[] nums){
        int max = 0;
        int len = nums.length;
        HashMap<Integer, Integer> majority = new HashMap<>();
        for(int i=0; i< nums.length; i++){
            if(majority.containsKey(nums[i])){
                int count = majority.get(nums[i]);
                majority.put(nums[i],count+1);
            }
            majority.put(nums[i], 1);
        }

       for(int key: majority.keySet()){
           if(majority.get(key)>len/2){
               max = key;
               break;
           }
       }

       return max;
    }

    public boolean isHappy(int n) {
        if(n == 1){
            return true;
        } else if (n > 1 && n <7) {
            return false;
        }else{
            int result = 0;
            while (n > 0){
                result += (n%10) *(n%10);
                n = n/10;
            }
            return  isHappy(result);
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode curr = dummy;      //Start of dummy node has a fake node then head node
        while(curr.next!=null){    //next node is the head of curr linked list
            if(curr.next.val==val){
                curr.next=curr.next.next;
            }
            else{
                curr=curr.next;
            }
        }
        return dummy.next;
    }

    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map=new LinkedHashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
        }
        for(Map.Entry<Integer,Integer>entry: map.entrySet()){
            if(entry.getValue()==1){
                return entry.getKey();
            }
        }
        return -1;
    }
}
