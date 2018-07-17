import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PairEqualsToSumFinder {
    public static void main(String args[]) {
        int matchingSum = 24;
        List<Integer> integerList = new ArrayList<>();
        integerList.add(12);
        integerList.add(8);
        integerList.add(18);
        integerList.add(6);
        integerList.add(15);
        integerList.add(12);

        Collections.sort(integerList);
        int left = 0;
        int right = integerList.size()-1;
        while(left<right) {
            if((integerList.get(left) + integerList.get(right)) > matchingSum) {
                right --;
                continue;
            }
            if((integerList.get(left) + integerList.get(right)) < matchingSum) {
                left ++;
                continue;
            }
            if((integerList.get(left) + integerList.get(right)) == matchingSum) {
                System.out.println("Pair - " + integerList.get(left) + ", " + integerList.get(right));
                left++;
                right--;
            }
        }
    }
}
