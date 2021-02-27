package STACK;

public class TestArrayStack {
    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>(10);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        System.out.println(arrayStack);
        arrayStack.pop();
        System.out.println(arrayStack);
        System.out.println(arrayStack.peek());
    }

}
