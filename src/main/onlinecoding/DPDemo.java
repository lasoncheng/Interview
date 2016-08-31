package onlinecoding;

import java.text.Format;
import java.util.Scanner;

/**
 * Created by lason on 8/4/16.
 */
public class DPDemo {
    public int bestSplit(int target, int []p){
        if(target == 0)
            return 0;
        int q = -1;
        for(int i = 1; i <= target; i++)
            q = maxNum(q, p[i] + bestSplit(target - i, p));
        return q;
    }

    public int maxNum(int a, int b){
        return a > b ? a:b;
    }

    /**
     *
     * @param arr
     * @return longest increasing sequences.  最长递增子序列
     * define state equation
     * f(i) end mark i
     * longest increasing sequences = max{f(1), f(2), ..., f(n)}
     * f(i) = max {f(x)| x < i, arr(x) < arr(i)} + 1
     */
    public int longIncreasingSequences(int []arr, int n){
        if(arr.length == 1)
            return 1;
        //length record
        int []dp = new int[n];
        //decision record.
        int []seq = new int[n];
        for(int i = 0; i < n ; i++){
            //when start, tmp[mark] is 0
            int mark = i;
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i] && dp[j] > dp[mark])
                    mark = j;
            }
            dp[i] = dp[mark] + 1;
            //mark is decision variable.
            seq[i] = mark;
        }

        //get max length.
        int max = 0;
        for(int i = 1; i < dp.length; i++){
            if(dp[i] > dp[max]){
                max = i;
            }
        }

        //get sequence.
        int mark = max;
        int k = dp[max];
        while(k > 0){
            System.out.println("***"+mark);
            System.out.println(arr[mark]);
            mark = seq[mark];
            k--;
        }
        //end get sequence.

        return dp[max];
    }

    /**
     *
     * @param arr
     * @return   max multiply value.
     */
    public int maxMulValue(int []arr){
       return 0;
    }

    /**
     *
     * @param arr
     * @return  max sum value with sequences.
     * 最大连续子数组和
     * Time Complexity.
     */
    public int  maxSumValue(int []arr){
        int start = 0;
        int end = 0;
        int max = -10000;
        for(int i = 0; i < arr.length; i++){
            int sum = 0;
            for(int j = i; j < arr.length; j++){
                sum += arr[j];
                if(sum > max){
                    max = sum;
                    start = i;
                    end = j;
                }
            }
        }
        return max;
    }

    public int maxSumValue_2(int []arr){
        int start = 0, end = 0;
        int tmp =0; //deal with all arr is negative num.
        int sum = 0;
        int greatestSum = -100000; //deal with add negative num condition.
        for(int i = 0; i < arr.length; i++){
            if(sum < 0)//如果当前最大和为负数，则舍弃前面的负数最大和，从下一个数开始计算
            {
                sum = arr[i];
                //start = i;  //if all num is negative, this is wrong expression.
                tmp = i;
            }
            else
                sum += arr[i];//如果当前最大和不为负数则加上当前数

            if(sum > greatestSum)//如果当前最大和大于全局最大和，则修改全局最大和
            {
                greatestSum = sum;
                start = tmp;
                end = i;
            }
        }
        return greatestSum;
    }

    public int maxSubArray_3(int[] nums) {
        int sum = 0, greatestSum = -100000;
        for(int i = 0; i < nums.length; i++){
            if(sum < 0)
                sum = nums[i];
            else
                sum += nums[i];
            if(sum > greatestSum)
                greatestSum = sum;
        }
        return greatestSum;
    }

    public int lastDeleteNum(int n){
        if(n > 1000)
            n = 1000;
        int []flag = new int[n];
        int sum = 0;
        int step = 0;
        for(int i = 0; i < n && sum < n-1;){
            if(flag[i] != 1){
                step++;
                if(step%3 == 0){
                    step = 0;
                    flag[i] = 1;
                    sum += 1;
                }
            }
            if(i == n-1)
                i = 0;
            else
                i++;
        }

        for(int i = 0; i < n; i++)
            if(flag[i] == 0)
                return i;
        return -1;
    }
     //TSP

    //Package Problem  0/1
    public int solvePackage(int n, int weight, int []v, int []w){
        int []dp = new int[weight + 1];
        for(int i = 1; i <= n; i++ )
        {
            for(int j = weight; j >= w[i]; j-- )
            {
                if( dp[j- w[i]] + v[i] > dp[j])
                    dp[j] = dp[j - w[i]] + v[i];
                System.out.print(dp[j]+" ");
            }
            System.out.println();
        }
        int value = dp[0];
        for(int i = 1; i <= weight; i++)
            if(dp[i] > value)
                value = dp[i];
        return value;
    }




    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int n = in.nextInt();
            int weight = in.nextInt();
            int []v = new int[n+1];
            int []w = new int[n+1];
            for(int i = 1; i <= n; i++){
                v[i] = in.nextInt();
            }

            for(int i = 1; i <= n; i++){
                w[i] = in.nextInt();
            }
            System.out.println(new DPDemo().solvePackage(n, weight, v, w));
        }

    }
}
