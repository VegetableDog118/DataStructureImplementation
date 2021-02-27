package LinkedList;

public class RecursionSum {
    public static int sum(int[] arr){
        return sum(arr,0);
    }

    /**
     * 计算l->n 这个区间的数组的和
     * @param arr
     * @param l
     * @return
     */
    public static int sum(int[] arr , int l){
        if(l == arr.length){
            return 0;
        }
        return arr[l] + sum(arr,l+1);
    }
}
