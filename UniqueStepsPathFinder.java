
public class UniqueStepsPathFinder {
    public static void main(String[] args) {
        System.out.println(calculateUniquePathFor1To3Steps(4));
        System.out.println(calculateUniquePathFor1To2Steps(4));
    }

    public static int calculateUniquePathFor1To3Steps(int n) {
        if(n == 0) {
            return 1;
        }
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        else {
            return (calculateUniquePathFor1To3Steps(n - 3) + calculateUniquePathFor1To3Steps(n - 2) + calculateUniquePathFor1To3Steps(n - 1));
        }
    }

    public static int calculateUniquePathFor1To2Steps(int n) {
        if(n == 0) {
            return 1;
        }
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        else {
            return (calculateUniquePathFor1To2Steps(n - 2) + calculateUniquePathFor1To2Steps(n - 1));
        }
    }
}
