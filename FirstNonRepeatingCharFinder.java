public class FirstNonRepeatingCharFinder {
    public static void main (String[] args) {
        System.out.println(getFirstNotRepeatedChar("gandhirajang"));
    }

    private static Character getFirstNotRepeatedChar(String input) {

        byte[] flags = new byte[256]; //all is initialized by 0

        for (int i = 0; i < input.length(); i++) { // O(n)
            flags[(int)input.charAt(i)]++ ;
        }

        for (int i = 0; i < input.length(); i++) { // O(n
            if(flags[(int)input.charAt(i)] == 1)
                return input.charAt(i);
        }

        return null;
    }
}
