package javalearn;

/**
 * Created by lason on 8/11/16.
 */
public class Permutation {
    public void perm(int arr[], int begin, int end) {
        if(end == begin){         //一到递归的出口就输出数组，此数组为全排列
            for(int i = 0; i <= end; i++)
                System.out.print(arr[i]+" ");
            System.out.println();
            return;
        }
        else{
            for(int j = begin; j<= end; j++){
                swap(arr, begin, j);      //for循环将begin~end中的每个数放到begin位置中去
                perm(arr, begin+1, end);  //假设begin位置确定，那么对begin+1~end中的数继续递归
                swap(arr, begin,j);      //换过去后再还原
            }
        }
    }
    public void swap(int []arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3};
        new Permutation().perm(arr, 0, arr.length-1);

    }
}
