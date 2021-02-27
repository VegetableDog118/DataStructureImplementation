package DynamicArr;

public class Test01 {
    public static void main(String[] args) {

        System.out.println("--------------");

        Array da = new Array(10);
        for(int i = 0 ; i < 9 ; i++){
            da.addLast(i);
        }
        System.out.println(da);

        da.addLast(1);

        da.addLast(1);

        System.out.println(da);

        System.out.println("-----------");

        Array testResize = new Array(5);
        for(int i = 0 ; i < 5 ; i++){
            testResize.addLast(i);
        }
        System.out.println(testResize);
        System.out.println();
        testResize.addLast(6);
        System.out.println(testResize);
        testResize.remove(5);
        testResize.remove(4);
        System.out.println(testResize);
        testResize.removeFirst();
        System.out.println(testResize);


    }

}
