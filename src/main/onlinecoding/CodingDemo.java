package onlinecoding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created by lason on 8/26/16.
 */
public class CodingDemo {
    //find the second max value in arr with O(N)
    public  int findSecondMaxValue(int []arr, int n) {
        if (arr.length <= 1)
            return -1;
        int max = arr[0];
        int second = arr[1];
        for(int i = 0; i < n; i++){
            if(arr[i] > max){
                second = max;
                max = arr[i];
            }
            else if(second < arr[i]){
                second = arr[i];
            }
        }
        return second;
    }

    public Pair findMaxMinValue(int []arr, int n){
        if (arr == null)
            return null;
        if(arr.length == 1){
            return new Pair(arr[0], arr[0]);
        }
        int max,min;
        if(arr[0] > arr[1]){
            max = arr[0];
            min = arr[1];
        }
        else{
            max = arr[1];
            min = arr[0];
        }
        for(int i = 2; i < n; i++){
            if(arr[i] > max){
                max = arr[i];
            }
            else if(arr[i] < min){
                min  = arr[i];
            }
        }
        return new Pair(max, min);
    }

    //find arr[i] + arr[j] = sum
    //arr must be sorted. if it is not sorted, should sort by quick sort.
    public Pair findSum(int []arr, int n, int sum){
        int i,j;
        for(i = 0, j = n -1; i < j; ){
            if(arr[i] + arr[j] == sum)
                return new Pair(i, j);
            else if(arr[i] + arr[j] < sum)
                i++;
            else
                j--;
        }
        return null;
    }

    class Pair{
        int val1;
        int val2;
        Pair(int val1, int val2){
            this.val1 = val1;
            this.val2 = val2;
        }

    }

    public boolean match(char []str) {
        Stack<Character> left = new Stack();
        HashMap<Character, Character> hash = new HashMap();
        hash.put('(', ')');
        hash.put('[', ']');
        hash.put('{', '}');
        for (int i = 0; i < str.length; i++) {
            Character c = str[i];
            if (c == '{' || c == '[' || c == '(')
                left.push(c);
            else if (!hash.get(left.pop()).equals(c)) {
                return false;
            }

        }
        return true;
    }


    public void adjustDown(int []arr, int n, int k){
        int tmp = arr[k];
        for(int i = 2*k; i <= n; i*=2){
            if(i < n && arr[i] < arr[i + 1]){
                i++;
            }
            if(tmp >= arr[i])
                break;
            else{
                arr[k] = arr[i];
                k = i;
            }
        }
        arr[k] = tmp;
    }

    //find K number in arr.
    public ArrayList<Integer> getLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList();
        if(input.length < k || k==0)
            return list;
        int []maxHeap = new int[k+1];
        for(int i = 0; i < k; i++)
            maxHeap[i + 1] = input[i];
        adjustDown(maxHeap, k, 1);
        for(int i = k; i < input.length; i++){
            if(input[i] < maxHeap[1]){
                maxHeap[1] = input[i];
                adjustDown(maxHeap, k, 1);
            }
        }
        for(int i = 1; i <= k; i++)
            list.add(maxHeap[i]);
        return list;
    }

    //subArray value and sequence, non dynamic programing method.
    public ArrayList<Integer> subArraySum(int []arr, int n){
        int start = 0, end = 0;
        int tmp = 0, sum = 0;
        int globalSum = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            if(sum < 0){
                sum  = arr[i];
                tmp = i;
            }
            else
                sum += arr[i];
            if(sum > globalSum){
                globalSum = sum;
                start = tmp;
                end = i;
            }
        }
        ArrayList list = new ArrayList();
        list.add(globalSum);
        list.add(start);
        list.add(end);
        return list;
    }

    //
    public int subArrayMul(int []arr, int n){
        int []s = new int[n];
        int []t = new int[n];
        s[0] = 1;
        t[0] = 1;
        int preSum = 1;
        int reverSum = 1;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n - 1; i++){
            preSum *= arr[i];
            reverSum *= arr[n - 1 - i];
            s[i + 1] = preSum;
            t[i + 1] = reverSum;
        }
        for(int i = 0; i < n; i++){
            int tmp = s[i] * t[n - 1 - i];
            if(tmp > max)
                max = tmp;
        }
        return max;
    }


    public static void main(String []args){
        int []arr = {-1,-3,-11};
        ArrayList<Integer> list = new CodingDemo().subArraySum(arr, arr.length);
        for(int e: list)
            System.out.println(e);
        int []arr2 = {1,2,5,4,3};
        System.out.println(new CodingDemo().subArrayMul(arr2, arr2.length));
    }

}
