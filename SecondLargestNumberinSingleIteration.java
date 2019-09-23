public class SecondLargestNumberinSingleIteration {
    public static void main(String[] args) {
        int inputArray[] = new int[] {1,5,8,9,4,5};
        System.out.println(findSecondMax(inputArray));
    }

    private static int findSecondMax(int[] inputArray) {
        int max;
        int secondMax;
        if(inputArray[0] > inputArray[1]) {
                max = inputArray[0];
                secondMax = inputArray[1];
        } else {
            max = inputArray[1];
            secondMax = inputArray[0];
        }

        for (int i=2; i<inputArray.length; i++) {
            if(inputArray[i] > secondMax) {
                if(inputArray[i] > max) {
                    secondMax = max;
                    max = inputArray[i];
                } else {
                    secondMax = inputArray[i];
                }
            }
        }
        return secondMax;
    }
}
