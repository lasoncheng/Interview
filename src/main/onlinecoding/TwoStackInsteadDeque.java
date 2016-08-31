package onlinecoding;

import java.util.Stack;

/**
 * Created by lason on 7/21/16.
 * Use two stack to achieve deque method push and pop.
 */
public class TwoStackInsteadDeque {
    Stack<Integer>  stack1 = new Stack();
    Stack<Integer>  stack2 = new Stack();
    boolean flag = false;

    public  void push(int node){
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        stack1.push(node);
    }

    public int pop(){
        flag = true;
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public static void main(String []args){
        TwoStackInsteadDeque s = new TwoStackInsteadDeque();
        s.push(1);
        s.push(2);
        System.out.println(s.pop());

    }

}
