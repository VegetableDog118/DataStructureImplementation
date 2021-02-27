package interview;

public class theKthSmallest {
    public int findKthSmallest(int[] nums,int k){
        int left = 0;
        int right = nums.length-1;
        while(true){
            int pos = partition(nums,left,right);
            if(pos+1 == k){
                return nums[pos];
            }else if(pos+1 < k){
                left = pos+1;
            }else{
                right = pos-1;
            }
        }
    }
    public void quickSort(int[] nums ){
        qs(nums,0,nums.length-1);
    }
    public void qs(int[] nums, int left ,int right){
        if(left <= right){
            int mid = partition(nums, left, right);
            qs(nums,left,mid-1);
            qs(nums,mid+1,right);
        }
    }

    private int partition(int[] nums , int left , int right){
        int pivot = nums[left];
        int l = left+1;
        int r = right;
        while(true){
            while(l<=r && nums[l]<= pivot){
                l++;
            }
            while(l<=r && nums[r] >= pivot){
                r--;
            }
            if(l>=r){
                break;
            }
            swap(nums,l,r);
        }
        swap(nums, left, r);
        return r;
    }

    private void swap(int[] nums , int l , int r){
        int temp =  nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1,5,6,4};
        theKthSmallest theKthSmallest = new theKthSmallest();
       // System.out.println(theKthSmallest.findKthSmallest(arr,4));
        theKthSmallest.quickSort(arr);
        for(int n : arr){
            System.out.println(n);
        }
        String a = "abcdefghijklm";
        System.out.println(a.substring(0,3));
    }
}
