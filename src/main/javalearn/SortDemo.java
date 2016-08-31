package javalearn;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by lason on 7/25/16.
 */
public class SortDemo {
    //insert sort
    public void insertSort(int []arr, int n){
        int tmp, i, j;
        for(i = 1; i < n; i++){
            if(arr[i] < arr[i-1]){
                tmp = arr[i];
                //j >= 0 is front of tmp < arr[j]
                for(j = i-1; j >= 0 && tmp < arr[j]; --j)
                      arr[j+1] = arr[j];
                arr[j + 1] = tmp;
            }
        }
    }

    //binary insert sort
    public void binaryInsertSort(int []arr, int n){
        int tmp, i, j;
        int low, mid, high;
        for(i = 1; i < n; i++){
            if(arr[i] < arr[i-1]){
                tmp = arr[i];
                low = 0;
                high = i -1;
                while(low <= high){
                    mid = (low + high)/ 2;
                    if(arr[mid] > tmp)
                        high = mid -1;
                    else
                        low = mid + 1;
                }
                for(j = i-1; j >= high + 1; --j)
                    arr[j+1] = arr[j];
                arr[high + 1] = tmp;
            }
        }
    }

    //shell sort
    public void shellSort(int []arr, int n){
        int dk, i, j, tmp;
        for(dk = n / 2; dk >= 1; dk /= 2){
            for(i = dk; i < n; i++){
                if(arr[i] < arr[i-dk]){
                    tmp = arr[i];
                    for(j = i - dk; j >=0 && tmp < arr[j]; j -= dk)
                        arr[j+dk] = arr[j];
                    arr[j+dk] = tmp;
                }
            }
        }
    }

    //bubble Sort
    public void bubbleSort(int []arr, int n){
        int i, j;
        boolean flag = true;
        for(i = 0; i < n-1; i++){
            for(j = n -1; j > i; --j)
                if(arr[j] < arr[j -1]){
                    swap(arr, j, j-1);
                    flag = false;
                }
            if(flag)
                break;
        }
    }

    public  void quickSort(int []arr, int start, int end){
        if(start >= end){
            return;
        }
        int pivotIndex = partition(arr, start, end);
        quickSort(arr, start, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, end);
    }


    //quick sort
    public int partition(int []arr, int start, int end){
        if(arr == null || start < 0 || end > arr.length - 1)
            System.out.println("invalid parameter");
        int randPivot = randomInRange(start, end);
        swap(arr, start, randPivot);
        int pivot = arr[start];
        //main idea. use the first blank space.
        while(start < end){
            while(start < end && arr[end] >= pivot) end--;
            arr[start] = arr[end];
            while(start < end && arr[start] <= pivot) start++;
            arr[end] = arr[start];
        }
        arr[start] = pivot;
        return start;
    }


    public int partition_2(int []arr, int start, int end){
        int index = randomInRange(start, end);
        System.out.println(index);
        swap(arr, index, end);
        int small = start - 1;
        //in this place ++index <=> index++
        for(index = start; index < end; ++ index){
            if(arr[index] < arr[end]){
                //in this place ++small <=> small ++
                //but arr[++small] is not equal to arr[small++]
                ++small;
                if(small != index)
                    swap(arr, index, small);
            }
        }
        ++small;
        swap(arr, small, end);
        return small;
    }

    public void quickSort_2(int []arr, int start, int end){
        if(start == end)
            return;
        int index = partition_2(arr, start, end);
        quickSort_2(arr, start, index - 1);
        quickSort(arr, index + 1, end);
    }

    //select sort.
    public void selectSort(int []arr, int n){
        int min;
        for(int i = 0; i < n - 1; i++){
            min = i;
            for(int j = i+1; j < n; j++)
                if(arr[j] < arr[min])
                    min = j;
            if(min != i)
                swap(arr, i, min);
        }
    }

    //Heap Sort  mark starts 1, not 0.
    public void  heapSort(int []arr, int n){
        buildMaxHeap(arr, n);
        for(int i = n; i > 1; i--){
            swap(arr, i, 1);
            adjustDown(arr, 1, i - 1);
        }
    }

    public void buildMaxHeap(int []arr, int n){
        for(int i = n/2; i > 0; i--)
            adjustDown(arr, i, n);
    }

    public void adjustDown(int []arr, int k, int n){
        int tmp = arr[k];
        for(int i = 2*k; i <= n; i*=2){
            if(i < n && arr[i] < arr[i+1])
                   i++;
            if(tmp >= arr[i])
                break;
            else {
                arr[k] = arr[i];
                k = i;
            }
        }
        arr[k] = tmp;
    }

    //merge sort.
    public void mergeSort(int[] arr, int left, int right) {
        if (left >= right)
            return;
        // 找出中间索引
        int center = (left + right) / 2;
        // 对左边数组进行递归
        mergeSort(arr, left, center);
        // 对右边数组进行递归
        mergeSort(arr, center + 1, right);
        // 合并
        merge(arr, left, center, right);

    }

    /**
     * 将两个数组进行归并，归并前面2个数组已有序，归并后依然有序
     *
     * @param data
     *            数组对象
     * @param left
     *            左数组的第一个元素的索引
     * @param center
     *            左数组的最后一个元素的索引，center+1是右数组第一个元素的索引
     * @param right
     *            右数组最后一个元素的索引
     */
    public void  merge(int[] data, int left, int center, int right) {
        // 临时数组
        int[] tmpArr = new int[data.length];
        // 右数组第一个元素索引
        int mid = center + 1;
        // third 记录临时数组的索引
        int third = left;
        // 缓存左数组第一个元素的索引
        int tmp = left;
        while (left <= center && mid <= right) {
            // 从两个数组中取出最小的放入临时数组
            if (data[left] <= data[mid]) {
                tmpArr[third++] = data[left++];
            } else {
                tmpArr[third++] = data[mid++];
            }
        }
        // 剩余部分依次放入临时数组（实际上两个while只会执行其中一个）
        while (mid <= right) {
            tmpArr[third++] = data[mid++];
        }
        while (left <= center) {
            tmpArr[third++] = data[left++];
        }
        // 将临时数组中的内容拷贝回原数组中
        // （原left-right范围的内容被复制回原数组）
        while (tmp <= right) {
            data[tmp] = tmpArr[tmp++];
        }
    }

    public int randomInRange(int start, int end){
        if(start > end){
            System.out.println("start must be less than end!");
            return -1;
        }
        Random rn = new Random();
        return start + rn.nextInt(end - start);
    }

    public static void swap(int []arr, int i, int j){
        int tmp;
        tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public int moreThanHalfNum(int []arr, int n){
        int mid = arr.length >> 1;
        int start = 0;
        int end = arr.length - 1;
        int pivot = partition(arr, start, end);
        while(mid != pivot){
            if(pivot > mid){
                end = pivot -1;
                pivot = partition(arr, start, end);
            }
            else{
                start = pivot + 1;
                pivot = partition(arr, start, end);
            }
        }
        return arr[mid];
    }

    public int MoreThanHalfNum_2(int [] array) {
        HashMap <Integer, Integer> hash = new HashMap();
        for(int i = 0; i < array.length - 1; i++){
            if(hash.containsKey(array[i])){
                hash.put(array[i], hash.get(array[i]) + 1);
                if(hash.get(array[i]) > array.length / 2)
                    return array[i];
            }
            else
                hash.put(array[i], 1);
        }
        return -1;
    }

    public static void main(String []args){
        int []arr = {0,5,1,2,34,7,5,68,3};
        new SortDemo().mergeSort(arr, 0, arr.length - 1);
        for(int elem: arr)
            System.out.println(elem);
        HashMap h = new HashMap();

    }
}
