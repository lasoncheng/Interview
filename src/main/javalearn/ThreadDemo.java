package javalearn;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lason on 7/30/16.
 */
public class ThreadDemo {
    private Lock codeLock;
    //add lock object.
    public int amount = 344;
    public  static  int i = 0;
    final int j = 3;
    public ThreadDemo(){
         codeLock = new ReentrantLock();
    }
    //we have two methods to control
    public  void lockFun(int num) {
        final int k =0;
        codeLock.lock();
        try {
            amount += num;
            // Thread.sleep(100);  compare to have no lock.
            amount -= num;

        }
        catch(Exception e){

        }
        finally{
            codeLock.unlock();
        }

        class test{
           public void test(){
               System.out.println(k);
           }
        }
    }

    public static void main(String []args){
        ThreadDemo td = new ThreadDemo();
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        for(int i = 0; i < 10; i++){
            Thread t = new Thread(new MyRunnable(td, num));
            t.start();
        }

        //
        final Object obj = new Object();
        Thread t1 = new Thread() {
            public void run() {
                //synchronized locks;
                synchronized (obj) {
                    try {
                        obj.wait();
                        System.out.println("Thread 1 weak up");
                    } catch (InterruptedException e) {

                    }

                }
            }
        };

        t1.start();
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){

        }
        Thread t2 = new Thread(){
            public void run(){
              synchronized (obj){
                  obj.notifyAll();
                  System.out.println("Thread 2 sent notify");
              }
            }

        };
        t2.start();
    }
}

class MyRunnable implements Runnable {
    public ThreadDemo td;
    public int num;

    public MyRunnable(ThreadDemo td, int num){
        this.td = td;
        this.num = num;
    }
    @Override
    public void run() {
        td.lockFun(num);
        System.out.println(td.amount);
    }
}

