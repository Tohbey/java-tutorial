package Linked_List.InterviewQuestion;

import java.util.HashSet;

public class LinkedListQuestion {

    public void deleteDuplicates(Node l1){
        Node tempNode = l1;
        Node prev = null;
        HashSet<Integer> set = new HashSet<Integer>();
        while (tempNode != null){
            if (set.contains(tempNode.value)){
                prev.next = tempNode.next;
            }else{
                set.add(tempNode.value);
                prev = tempNode;
            }
            tempNode = tempNode.next;
        }
    }

    public Node returnNthToLast(Node l1, int n){
        Node tempNode = l1;
        Node tempNode2 = l1;
        for(int i=0;i<n;i++){
            if(tempNode2 == null) return null;
            tempNode2 = tempNode2.next;
        }

        while (tempNode2 != null){
            tempNode = tempNode.next;
            tempNode2 = tempNode2.next;
        }
        return  tempNode;
    }

    public Node partitionList(Node l1, int n){
        Node leftList = new Node();
        Node rightList = new Node();
        Node ltail = leftList;
        Node rtail = rightList;

        Node tempNode = l1;

        while (tempNode != null){
            if(tempNode.value >= n){
                rightList.next = tempNode;
                rtail = rightList.next;
            }else{
                leftList.next = tempNode;
                ltail = leftList.next;
            }
            tempNode = tempNode.next;
        }

        ltail.next = rightList.next;
        rtail.next = null;

        return leftList.next;
    }

    public Node sumList(Node l1, Node l2){
        Node sum = new Node();
        Node current = null;

        int carry = 0;


        Node tempNodeL1 = l1;
        Node tempNodeL2 = l2;

        while (tempNodeL1 != null || tempNodeL2 != null){
            if(tempNodeL1 != null){
                carry += tempNodeL1.value;
                tempNodeL1 = tempNodeL1.next;
            }

            if(tempNodeL2 != null){
                carry += tempNodeL2.value;
                tempNodeL2 = tempNodeL2.next;
            }

            if(carry > 10){
                carry = carry/10;
                current = new Node(carry%10);
            }else{
                current = new Node(carry);
            }
            sum.next = current;
        }
        return sum;
    }
}
