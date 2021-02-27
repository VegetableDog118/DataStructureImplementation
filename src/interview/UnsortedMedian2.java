package interview;

import java.util.PriorityQueue;

public class UnsortedMedian2 {

    public double getMedian(int[] nums){
        if(nums.length == 0){
            return 0;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0 ; i < nums.length ;i++){
            minHeap.add(nums[i]);
            if(minHeap.size() > nums.length/2+1){
                minHeap.poll();
            }
        }

        if(nums.length % 2 == 0){
            return (double) ((minHeap.poll()+minHeap.peek())/2.0);
        }else{
            return (double) minHeap.peek();
        }
    }




    public static void main(String[] args) {
        UnsortedMedian2 unsortedMedian2 = new UnsortedMedian2();
        int[] test1 = new int[]{2,5,4,3,1};
        System.out.println(unsortedMedian2.getMedian(test1));

    }
}
