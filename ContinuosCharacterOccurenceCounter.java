public class ContinuosCharacterOccurenceCounter {

    public static void main(String[] args) {
        String inputString = "ABBBCCGHHGII";
        System.out.println(characterCounter(inputString));
    }

    public static String characterCounter(String inputString) {
        StringBuilder builder = new StringBuilder();
        char previousChar = inputString.charAt(0);
        int count = 1;
        for (int i = 1; i < inputString.length(); i++) {
            if (previousChar == inputString.charAt(i)) {
                count++;
            } else {
                builder.append(count > 1 ? previousChar + "" + count : previousChar);
                count = 1;
                previousChar = inputString.charAt(i);
            }
        }
        if (count > 1) {
            builder.append(previousChar + "" + count);
        } else {
            builder.append(previousChar);
        }
        return builder.toString();
    }
}
