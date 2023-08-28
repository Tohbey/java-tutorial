package Tree.BinaryTree;

import Tree.BinaryNode;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLinked {
    BinaryNode<Integer> root;

    public BinaryTreeLinked(){
        this.root = null;
    }

    public void preOrder(BinaryNode node){
        if(node == null){
            return;
        }

        System.out.println(node.value +"->");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(BinaryNode node){
        if(node == null){
            return;
        }

        inOrder(node.left);
        System.out.println(node.value +"->");
        inOrder(node.right);
    }

    public void postOrder(BinaryNode node){
        if(node == null){
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value +"->");
    }

    public void levelOrder(BinaryNode node){
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
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

    public void searchValue(int value){
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while (!queue.isEmpty()){
            BinaryNode presentNode = queue.remove();
            System.out.println(presentNode.value+" ");
            if(presentNode.value.equals(value)){
                System.out.println("Value is found "+presentNode.value+" in the tree");
                return;
            }else{
                if(presentNode.left != null){
                    queue.add(presentNode.left);
                }

                if(presentNode.right != null){
                    queue.add(presentNode.right);
                }
            }
        }

        System.out.println("Value is not found in the tree");
    }

    public void insertNode(int value){
        BinaryNode node = new BinaryNode();
        node.value = value;
        if(root == null){
            root = node;
            System.out.println("Inserted new node at root");
            return;
        }


        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while (!queue.isEmpty()){
            BinaryNode presentNode = queue.remove();
            System.out.println(presentNode.value+" ");
            if(presentNode.left == null){
                presentNode.left = node;
                System.out.println("Inserted new node at left node");
                break;
            }else if(presentNode.right == null){
                presentNode.right = node;
                System.out.println("Inserted new node at left node");
                break;
            }else {
                queue.add(presentNode.left);
                queue.add(presentNode.right);
            }
        }
    }


    public void deleteDeepestNode(){
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode presentNode = null;
        BinaryNode previousNode = null;
        while (!queue.isEmpty()){
            previousNode = presentNode;
            presentNode = queue.remove();

            if(presentNode.left == null){
                previousNode.right = null;
                return;
            } else if (presentNode.right == null) {
                previousNode.left = null;
                return;
            }

            queue.add(presentNode.left);
            queue.add(presentNode.right);
        }
    }

    public BinaryNode getDeepestNode(){
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode presentNode = null;
        while (!queue.isEmpty()){
            presentNode = queue.remove();
            if(presentNode.left != null){
                queue.add(presentNode.left);
            }

            if(presentNode.right != null){
                queue.add(presentNode.right);
            }
        }

        return presentNode;
    }

    public void deleteNode(String value){
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            BinaryNode presentNode = queue.remove();
            if(presentNode.value == value){
                presentNode.value = getDeepestNode().value;
                deleteDeepestNode();
                System.out.println("The node is deleted");
                return;
            }else{
                if(presentNode.left != null){
                    queue.add(presentNode.left);
                }

                if(presentNode.right != null){
                    queue.add(presentNode.right);
                }
            }
        }

        System.out.println("Node doesnt exist in binary tree");
    }
}
