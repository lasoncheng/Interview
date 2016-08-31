package onlinecoding;


/**
 * Created by lason on 7/29/16.
 */
class C {
    B b = new B();
    public C(){
        System.out.println("C");
    }
}

class B {
    public B(){
        System.out.println("B");
    }
}

public class A extends C{
    B b = new B();
    public A(){
        System.out.println("A");
    }

    public static int test(int num){
        try{
            num += 10;
            return num;
        }
        catch(RuntimeException e){

        }
        catch(Exception e){

        }
        finally {
            num += 10;
            return num;
        }
    }

    public static void main(String []args){
        new A();
        System.out.println(test(10));
    }
}