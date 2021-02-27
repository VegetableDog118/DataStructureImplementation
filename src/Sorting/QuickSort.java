package Sorting;

import java.util.Arrays;
import java.util.HashMap;

public class QuickSort {

    private void quicksort(int[] nums){
        quicksort(nums ,0 ,nums.length-1);
    }

    private void quicksort(int[] nums, int left, int right) {
        if(left<=right){
            int index = partition(nums, left, right);
            quicksort(nums,left,index-1);
            quicksort(nums,index+1  ,right);
        }
    }

    private int partition(int[] nums , int left , int right){
        int pivot = nums[left];
        int l = left+1;
        int r = right;
        while(true){
            while(l<=r && nums[l]<=pivot){
                l++;
            }
            while(l<=r && nums[r]>=pivot){
                r--;
            }
            if(l>=r){
                break;
            }
            swap(nums,l,r);
        }
        swap(nums,left,r);
        return r;
    }


    private void swap(int[] nums , int l , int r){
        int temp = nums[r];
        nums[r] = nums[l];
        nums[l] = temp;
    }

    static class Student{
        String name;
        public Student(String n){
            this.name = n;
        }
    }





    public static void main(String[] args) {
        int[] a = {1, 2, 4, 5, 7, 4, 5 ,3 ,9 ,0};
        System.out.println(Arrays.toString(a));
        QuickSort q = new QuickSort();
        q.quicksort(a);
        System.out.println(Arrays.toString(a));

        HashMap<Object,String> map = new HashMap<>();
        Student s = new Student("a");
        map.put(s,"a");
        s.name = "b";
        System.out.println(map.get(s));
        String c = "1";
        int b = 1;
        System.out.println(c.equals(b));

    }
}
