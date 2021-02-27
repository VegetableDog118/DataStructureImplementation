package SegmentTree;



public class TestSegmentTree {
    public static void main(String[] args) {
        Integer[] nums = {-2 , 0 , 3 , -5 , 2 , -1};
        SegmentTree<Integer> segmentTree = new SegmentTree<Integer>(nums, new Merger<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a + b;
            }
        });

        System.out.println(segmentTree);
        System.out.println();
        System.out.println(segmentTree.query(0,2));
    }
}
