package interview;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by lason on 8/28/16.
 */
public class Test {
    public int maxProfits(int []arr){
        if(arr.length == 1 || arr.length == 0)
            return 0;
        int maxProfits = Integer.MIN_VALUE;
        int currentProfits;
        for(int i = 0; i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++){
                currentProfits = arr[j] - arr[i];
                if(currentProfits > maxProfits){
                    maxProfits = currentProfits;
                }

            }
        }
        return maxProfits;
    }

    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String []strs = in.nextLine().split(" ");
            int n = strs.length;
            int []arr = new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(strs[i]);
            System.out.println(new Test().maxProfits(arr));
        }
        System.out.print(Integer.MAX_VALUE);
    }
}
