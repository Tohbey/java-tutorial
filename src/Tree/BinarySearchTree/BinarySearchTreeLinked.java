package Tree.BinarySearchTree;

import Tree.BinaryNode;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeLinked {
    BinaryNode root;

    public BinarySearchTreeLinked(){
        root = null;
    }

    public void insert(int value){
        inset(root, value);
    }

    private BinaryNode inset(BinaryNode<Integer> currentNode, int value){
        if(currentNode == null){
            BinaryNode newNode = new BinaryNode();
            newNode.value = value;
            System.out.println("The value successfully inserted");
            return newNode;
        }else if(currentNode.value >= value){
            currentNode.left = inset(currentNode.left, value);
            return currentNode;
        }else{
            currentNode.right = inset(currentNode.right, value);
            return currentNode;
        }
    }

    public void searchValue(int value){
        Queue<BinaryNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            BinaryNode<Integer> presentNode = queue.remove();
            System.out.println(presentNode.value+" ");
            if(presentNode.value == value){
                System.out.println("Value is found "+presentNode.value+" in the tree");
            } else if (presentNode.value < value) {
                queue.add(presentNode.right);
            }else{
                queue.add(presentNode.left);
            }
        }
        System.out.println("Value is not found in the tree");
    }

    public BinaryNode searchBinaryNode(BinaryNode<Integer> node, int value){
        if(node == null){
            System.out.println("Value: "+value+" not found in BST");
            return null;
        }else if(node.value == value){
            System.out.println("Value is found "+node.value+" in the tree");
            return node;
        } else if (node.value > value) {
            return searchBinaryNode(node.left, value);
        }else{
            return searchBinaryNode(node.right, value);
        }
    }



    public void preOrder(BinaryNode node){
        if(node == null){
            return;
        }

        System.out.println(node.value +"->");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void postOrder(BinaryNode node){
        if(node == null){
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value +"->");
    }

    public void inOrder(BinaryNode node){
        if(node == null){
            return;
        }

        inOrder(node.left);
        System.out.println(node.value +"->");
        inOrder(node.right);
    }

    public void levelOrder(BinaryNode node){
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            BinaryNode presentNode = queue.remove();
            System.out.println(presentNode.value+" ");

            if(presentNode.left != null){
                queue.add(presentNode.left);
            }

            if(presentNode.right != null){
                queue.add(presentNode.right);
            }
        }
    }

    public static BinaryNode minimumNode(BinaryNode<Integer> root){
        if(root.left == null){
            return root;
        }else{
            return minimumNode(root.left);
        }
    }
    public BinaryNode deleteNode(BinaryNode<Integer> root, int value){
        BinaryNode<Integer> node = searchBinaryNode(root, value);

        if(node != null){
            if(node.left != null && node.right != null){
                BinaryNode<Integer> temp = root;
                BinaryNode<Integer> minNodeForRight = minimumNode(temp.right);
                node.value = minNodeForRight.value;
                node.right = deleteNode(node.right, minNodeForRight.value);
            }else if (node.left != null){
                node = node.left;
            } else if (node.right != null) {
                node = node.right;
            }else{
                node = null;
            }
        }

        return node;
    }
}
