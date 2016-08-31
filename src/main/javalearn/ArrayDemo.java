package javalearn;

import interview.Demo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by lason on 7/6/16.
 */
public class ArrayDemo {
    /**
     * P40
     * @param arr  two dimensional array.
     * @param value  the found value.
     * @return  boolean. whether the found value in two dimensional array.
     */
    public static boolean  findValue(int [][] arr, int value){
        int rowLength = arr.length;
        int colLength = arr[0].length;
        for(int i = 0; i < rowLength; i++)
            for(int j = colLength - 1; j >= 0; j--) {
                if(arr[i][j] > value)
                    colLength--;  //delete this column.
                else if(arr[i][j] < value)
                    break;   //jump this row.
                else
                    return true;
            }
        return false;
    }

    public static void main(String []args){
        //define array variable.
        int []arr = new int[100];
        int arr1[] = new int[100];
        int []arr2 = {1,2,3};

        int [][] arr3 = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        //same struct in java.
        System.out.println(ArrayDemo.findValue(arr3,0));

        List <Integer> list = new ArrayList <Integer> ();
        LinkedList  linkedList = new LinkedList();
        int  [][] arr5 = {{}};
        String a = "abc";



    }
}


