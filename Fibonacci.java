public class Fibonacci {
    public static void main(String args[]) {
        for(int i = 0;i<9; i++) {
            System.out.println(calculate(i));
        }

    }

    public static int calculate(int n) {
        if(n<=1) {
            return n;
        }
        return calculate(n-1) + calculate(n-2);
    }
}
