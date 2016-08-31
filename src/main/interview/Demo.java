package interview;


import breeze.optimize.linear.LinearProgram;
import org.apache.spark.sql.catalyst.expressions.In;

import java.util.*;
import java.lang.*;
public class Demo {
    public int getCommonStrLength(char[] pFirstStr, char[] pSecondStr) {
        int pLen = pFirstStr.length;
        int max = 0;
        for (int i = 0; i < pLen; i++)
            for (int j = i; j < pLen; j++)
                if (isExist(pFirstStr, pSecondStr, i, j) && max < j - i + 1)
                    max = j - i + 1;
        return max;
    }

    public boolean isExist(char[] pFirstStr, char[] pSecondStr, int i, int j) {
        int sLen = pSecondStr.length;
        int k = 0;
        int tmp = i;
        while (k < sLen) {
            while (k < sLen && i <= j) {
                if (pFirstStr[i] != pSecondStr[k]) {
                    i = tmp;
                    k = i - tmp;
                }
                i++;
                k++;
            }
            if (i == j)
                return true;
        }
        return false;
    }

    public int longIncreasingSequences(int[] arr, int n) {
        int[] tmp = new int[n];
        for (int i = 0; i < n; i++) {
            int mark = i;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && tmp[j] > tmp[mark])
                    mark = j;
            }
            tmp[i] = tmp[mark] + 1;
        }

        int max = 0;
        int k = 0;
        for (int i = 1; i < tmp.length; i++) {
            if (tmp[i] > max)
                max = tmp[i];
        }
        return max;
    }

    public void buildMaxHeap(int []arr, int n){
        for(int i = n/2; i > 0; i--)
            adjustDown(arr, n, i);
    }

    public void adjustDown(int []arr, int n, int k){
        int tmp = arr[k];
        for(int i = 2*k; i <= n; i*=2){
            if(i < n && arr[i] < arr[i+1])
                i++;
            if(tmp >= arr[i])
                break;
            else{
                arr[k] = arr[i];
                k = i;
            }
        }
        arr[k] = tmp;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList list = new ArrayList();
        int []maxHeap = new int[k+1];
        for(int i = 0; i < k; i++)
            maxHeap[i+1] = input[i];
        for(int i = k; i < input.length; i++){
            System.out.println("*" + maxHeap[1]);
            if(maxHeap[1] > input[i]){
                maxHeap[1] = input[i];
                adjustDown(maxHeap, k, 1);
            }
        }
        for(int i = 1; i <= k; i++){
            list.add(maxHeap[i]);
        }
        return list;
    }
    public static void main(String []args) {
        int []arr = {4,5,1,6,2,7,3,8};
        List<Integer> a = new Demo().GetLeastNumbers_Solution(arr, 4);
        for(int e:a)
            System.out.println(e);
    }
}

