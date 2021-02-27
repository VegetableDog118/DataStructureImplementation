package interview;

public class ParseInt {

    public static int parseInt(String str) {
        boolean negative = false;
        int i = 0;
        if(str.charAt(0) == '-'){
            negative = true;
            i++;
        }
        int temp = 0;
        for(int j = i ; j < str.length() ; j++){
            temp = temp*10 + str.charAt(j) - '0';
        }

        if(negative){
            temp = temp*(-1);
        }

        return temp;
    }

    public static void main(String[] args) {
        ParseInt parseInt = new ParseInt();
        System.out.println(parseInt(("-123456")));
    }
}
