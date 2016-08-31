package javalearn;

import java.util.*;

/**
 * Created by lason on 7/14/16.
 * 3 => 6 (recursive call or stack method),
 */
public class TreeDemo <T>{
    private TreeNode root;

    public void initTree(T value){
         this.root = new TreeNode(value);
    }

    public void initTree(T value, T left_value, T right_value){
        this.root = new TreeNode(value, left_value, right_value);
    }

    public void add(TreeNode pHead, T left_value, T right_value){
        TreeNode leftNode = new TreeNode(left_value);
        TreeNode rightNode = new TreeNode(right_value);
        pHead.left = leftNode;
        pHead.right = rightNode;
    }

    public void addLeft(TreeNode pHead, T value){
        TreeNode leftNode = new TreeNode(value);
        pHead.left = leftNode;
    }

    public void addRight(TreeNode pHead, T value){
        TreeNode rightNode = new TreeNode(value);
        pHead.right = rightNode;
    }

    public void preOrder(TreeNode pHead){
        if(pHead != null){
            System.out.println(pHead.value);
            preOrder(pHead.left);
            preOrder(pHead.right);
        }
    }

    public void inOrder(TreeNode pHead){
        if(pHead != null){
            inOrder(pHead.left);
            System.out.println(pHead.value);
            inOrder(pHead.right);
        }
    }

    public void postOrder(TreeNode pHead){
        if(pHead != null){
            postOrder(pHead.left);
            postOrder(pHead.right);
            System.out.println(pHead.value);
        }
    }

    //three methods for non-recursive call traversal.
    public void nonRecursivePreOrder(){
        Stack<TreeNode> tempStack = new Stack();
        TreeNode pHead = this.root;
        while(pHead != null || !tempStack.isEmpty()){
            if(pHead != null){
                System.out.println(pHead.value);
                if(pHead.left != null)
                    tempStack.push(pHead);
                pHead = pHead.left;
            }
            else{
                pHead = tempStack.pop();
                pHead = pHead.right;
            }
        }
    }

    public void nonRecursiveInOrder(){
        Stack<TreeNode> tempStack = new Stack();
        TreeNode pHead = this.root;
        while(pHead != null || !tempStack.isEmpty()){
            if(pHead != null){
                tempStack.push(pHead);
                pHead = pHead.left;
            }
            else{
                pHead = tempStack.pop();
                System.out.println(pHead.value);
                pHead = pHead.right;
            }
        }
    }

    public void nonRecursivePostOrder() {
        Stack<TreeNode> tempStack = new Stack();
        TreeNode pHead = this.root;
        TreeNode r = null;
        while(pHead != null || !tempStack.isEmpty()){
            if(pHead != null){
                tempStack.push(pHead);
                pHead = pHead.left;
            }
            else{
                pHead  = tempStack.peek();
                if(pHead.right != null && pHead.right != r){
                    pHead = pHead.right;
                    tempStack.push(pHead);
                    pHead = pHead.left;
                }

                else{
                    pHead = tempStack.pop();
                    System.out.println(pHead.value);
                    r = pHead;
                    pHead = null;
                }
            }
        }

    }

    //Hierarchical traversal
    public void hierTraversal(){
        TreeNode pHead = this.root;
        Deque<TreeNode> deque = new ArrayDeque();
        while(pHead != null){
            System.out.println(pHead.value);
            if(pHead.left != null)
                deque.add(pHead.left);
            if(pHead.right != null)
                deque.add(pHead.right);
            if(!deque.isEmpty())
                pHead = deque.pop();
            else
                pHead = null;
        }
    }


    //according preOrder and inOrder sequences to recreate tree.
    //preOrder {1, 2, 4, 7, 3, 5, 6, 8}
    //inOrder  {4, 7, 2, 1, 5, 3, 8, 6}
    public TreeNode reCreateTreeByPreAndInOrder(T []preOrder, int start, T []inOrder, int end, int length){
        //validate data.
        if (preOrder == null || preOrder.length == 0 || inOrder == null
                || inOrder.length == 0 || length <= 0) {
            return null;
        }

        TreeNode pHead = new TreeNode(preOrder[start]);
        if(length == 1){
            return pHead;
        }
        int i = 0;
        for(; i < length; i++){
            if(pHead.value == inOrder[end - i])
                break;
        }

        // 建立子树的左子树
        pHead.left = reCreateTreeByPreAndInOrder(preOrder, start + 1, inOrder, end - i - 1, length - 1 - i);
        // 建立子树的右子树
        pHead.right = reCreateTreeByPreAndInOrder(preOrder, start + length - i, inOrder, end, i);
        return pHead;
    }

    public static class TreeNode <T>{
        T value;
        TreeNode left;
        TreeNode right;
        public TreeNode(T value){
            this.value = value;
        }

        public TreeNode(T value, T left_value, T right_value){
            this.value = value;
            this.left = new TreeNode(left_value);
            this.left.value = left_value;
            this.right = new TreeNode(right_value);
            this.right.value = right_value;
        }
    }

    public static void main(String []args){
        //case one
        TreeDemo tree1= new TreeDemo();
        tree1.initTree(1,2,3);
        tree1.add(tree1.root.left, 4, 5);
        tree1.add(tree1.root.right, 6, 7);

        //tree1.nonRecursivePreOrder();
        //tree1.nonRecursiveInOrder();
        //tree1.nonRecursivePostOrder();

        //tree1.hierTraversal();
        System.out.println("*********************");

        //case two
        TreeDemo tree2 = new TreeDemo();
        tree2.initTree(1,2,3);
        tree2.addRight(tree2.root.left, 4);
        tree2.addLeft(tree2.root.right, 5);

        //tree2.nonRecursivePreOrder();
        //tree2.nonRecursiveInOrder();
        //tree2.nonRecursivePostOrder();

        //tree2.hierTraversal();

        //create tree
        Integer []preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        Integer []inOrder  = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeDemo<Integer> tree3 = new TreeDemo ();
        tree3.root = tree3.reCreateTreeByPreAndInOrder(preOrder, 0, inOrder, preOrder.length - 1, preOrder.length);
        tree3.preOrder(tree3.root);
        System.out.println("*********************");
        tree3.inOrder(tree3.root);
        System.out.println("*********************");
        tree3.hierTraversal();

        //how to use stack and deque
        Stack stack = new Stack();
        int []elem = {1,2,3,4,5,6};
        for(int e: elem){
            stack.add(e);
        }
        //System.out.println(stack.pop());l

        //array deque
        Deque arrayDeque = new ArrayDeque();
        for(int e: elem){
            arrayDeque.add(e);
        }
        //System.out.println(arrayDeque.pop());


        //linkedList deque
        Deque linkedDeque = new LinkedList();
        for(int e: elem){
            linkedDeque.add(e);
        }
        //System.out.println(linkedDeque.pop());


        TreeSet treeSet = new TreeSet();

    }
}
