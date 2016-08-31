package javalearn;

/**
 * Created by lason on 7/25/16.
 * Binary Search,  Tree Search, Hash Search and so on.
 */
public class SearchDemo {
    // arr is a sorted array.
    public  int binarySearch(int []arr, int low, int high, int target){
        int mid;
        while(low <= high){
            mid = (low + high) / 2 ;
            if(arr[mid] < target){
                low = mid + 1;
            }
            else if(arr[mid] > target){
                high = mid - 1;
            }
            else
                return mid;
        }
        return -1;
    }


    public boolean binarySearch_2(int []arr, int low, int high, int target){
        int mid = 0;
        while(low <= high){
            mid = (low + high)/ 2 ;
            if(arr[mid] < target)
                 low = mid + 1;
            else if(arr[mid] > target)
                 high = mid - 1;
            else
                return true;
        }
        return false;
    }

    public static void main(String []args){
        int []arr = {1,2,4,5,6,7,8,9,10};
        System.out.println(new SearchDemo().binarySearch(arr, 0, arr.length-1, 4));

    }
}
