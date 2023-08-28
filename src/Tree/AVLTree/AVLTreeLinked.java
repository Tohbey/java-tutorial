package Tree.AVLTree;

import Tree.BinaryNode;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTreeLinked {
    BinaryNode root;

    public AVLTreeLinked(){
        root = null;
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


}
