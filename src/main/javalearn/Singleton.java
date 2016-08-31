package javalearn;

/**
 * Created by lason on 7/6/16.
 */

//method one.  use final global variable.
// But this way need every developer know the final instance variable name.
public class Singleton {
    public static final Singleton instance = new Singleton();

    private Singleton(){}  //private permission.

    public void printInfo(){
        System.out.println("this is a test singleton instance");
    }
    public static void main(String args[]){
        instance.printInfo();
    }
}

//method two. use getInsingleton to make sure one instance for singleton class.
class Singleton1 {
    private static Singleton1 uniqueInstance = new Singleton1();

    private Singleton1(){
    }
    public static Singleton1 getInstance(){
        return uniqueInstance;
    }
    //...Remainder omitted
    public void printInfo(){
        System.out.println("this is a test singleton instance");
    }

    public static void main(String args[]){
        Singleton1 uniqueInstance = getInstance();
        //this way can make sure only one instance for Singleton class. the only object is uniqueInstance.
    }
}

//method three.
class Singleton2 {
    private static Singleton2 uniqueInstance = null;

    private Singleton2(){
    }
    public static Singleton2 getInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new Singleton2();
        }
        return uniqueInstance;
    }
    //...Remainder omitted
    public void printInfo(){
        System.out.println("this is a test singleton instance");
    }
}

//method four.

  class Singleton3 {
    private static Singleton3 uniqueInstance ;

    private Singleton3(){
    }
    public synchronized static Singleton3 getInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new Singleton3();
        }
        return uniqueInstance;
    }
    //...Remainder omitted
    public void printInfo(){
        System.out.println("this is a test singleton instance");
    }

    public void main(String args[]){
        System.out.print(uniqueInstance == null);
    }
}