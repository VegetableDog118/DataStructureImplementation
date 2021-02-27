package BST;
import java.util.ArrayList;
import java.util.Random;
public class Test {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<Integer>();
        int[] ints = {5,3,6,8,4,2};
        for(int num : ints){
            bst.add(num);
        }
        bst.preOrder();
        System.out.println();
        //bst.preOrderNR();
        System.out.println();
        bst.levelOrder();
        System.out.println();
        bst.inOrder();
        System.out.println();
        bst.postOrder();

        Random random = new Random();

        //test remove min
        int n = 1000;
        for(int i = 0 ; i < n ; i++){
            bst.add(random.nextInt(10000));
        }

        ArrayList arrayList = new ArrayList();
        while(!bst.isEmpty()){
            arrayList.add(bst.removeMin());
        }

        System.out.println(arrayList);//从小到大的排序

        //Bst test delete
        BST<Integer> bst1 = new BST<Integer>();
        int[] ints1 = {5,4,6,8,2};
        for(int num : ints1){
            bst1.add(num);
        }
        bst1.remove(2);
        bst1.preOrder();
        System.out.println();
        bst1.remove(6);
        bst1.preOrder();
    }



}