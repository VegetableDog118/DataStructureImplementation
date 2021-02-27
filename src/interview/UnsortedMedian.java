package interview;

public class UnsortedMedian {

    public int findMedian(int[] nums){

        if(nums.length == 0){
            return 0;
        }

        int l = 0;
        int r = nums.length-1;
        int midIndex = r/2;

        while(true){
            int pos = partition(nums,l,r);
            if(pos+1 == midIndex){
                return nums[pos];
            }else if(pos+1>midIndex){
                r = pos-1;
            }else{
                l = pos+1;
            }
        }
    }

    private  int partition(int[] nums , int left ,int right){
        int pivot = nums[left];
        int l = left+1;
        int r = right;
        while(true){

            while(l<=r && nums[pivot]<=nums[l]){
                l++;
            }
            while(l<=r && nums[r]>=nums[pivot]){
                r--;
            }
            if(l>=r) {
                break;
            }
            swap(nums,l,r);
        }
        swap(nums,left,r);
        return r;
    }

    private void swap(int[] nums , int l , int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public static void main(String[] args) {
        UnsortedMedian unsortedMedian = new UnsortedMedian();
        int[] nums = new int[]{1,3,2,5,4};
        System.out.println(unsortedMedian.findMedian(nums));
        System.out.println(5/2);
    }
}

