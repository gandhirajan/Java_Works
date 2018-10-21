import java.util.ArrayList;
import java.util.List;
/* Class to find the minimum number of swaps required to arrange same strings together in a list */
public class MinimumStringSwapFinder {
    public static void main(String args[]) {
        List<String> inputStringList = new ArrayList<>();
        inputStringList.add("Roger");
        inputStringList.add("Federer");
        inputStringList.add("Rahul");
        inputStringList.add("Rahul");
        inputStringList.add("Roger");
        inputStringList.add("Federer");
        System.out.println(findMinimumAdjacentSwaps(inputStringList));
    }


    private static  int findMinimumAdjacentSwaps(List<String> inputStringList) {
        List<String> visitedList = new ArrayList<>();
        int minimumSwaps = 0;
        for (int i = 0; i < inputStringList.size(); i++) {
            if (!visitedList.contains(inputStringList.get(i))) {
                visitedList.add(inputStringList.get(i));

                int count = 0;
                for (int j = i + 1; j < inputStringList.size(); j++) {
                   if (!visitedList.contains(inputStringList.get(j)))
                        count++;

                    else if (inputStringList.get(i).equals(inputStringList.get(j)))
                        minimumSwaps += count;
                }
            }
        }
        return minimumSwaps;
    }
}
