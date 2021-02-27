package HEAP;

import java.util.*;
import java.util.PriorityQueue;

public class LeetCode347 {
    public int[] topKFrequent(int[] nums, int k) {

        TreeMap<Integer, Integer> map = new TreeMap<>();

        //生成一个元素频率映射表
        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num) + 1);
            }else{
                map.put(num,1);
            }
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });

        for(int key : map.keySet()){
            if(priorityQueue.size() < k){
                priorityQueue.add(key);
            }else if(map.get(key) > map.get(priorityQueue.peek())){
                // 如果这个频率大于堆顶的频率，就用这个来替代堆顶的元素，而且java的优先队列的heap是一个min heap所以heap的最顶端是频率最小的
                priorityQueue.remove();
                priorityQueue.add(key);
            }
        }

        ArrayList list = new ArrayList();
        while(!priorityQueue.isEmpty()){
            list.add(priorityQueue.remove());
        }

        int[] ret = new int[list.size()];
        for(int i = 0 ; i < list.size(); i++){
            ret[i] =(Integer) list.get(i);
        }

        return ret;
    }
}
