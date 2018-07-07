/* Java class to find the longest common suffix between two strings */
public class LongestCommonSuffixFinder {
    public static void main(String args[]) {
        String firstInputString = "Passion";
        String secondInputString = "Caution";
        String reverseFirstString = new StringBuilder(firstInputString).reverse().toString();
        String reverseSecondString = new StringBuilder(secondInputString).reverse().toString();
        int length = (reverseFirstString.length() < secondInputString.length())? reverseFirstString.length():reverseSecondString.length();
        String commonSuffix = "";
        for (int i=0;i<length;i++) {
            if(reverseFirstString.charAt(i) != reverseSecondString.charAt(i)) {
                break;
            }
            else {
                commonSuffix += reverseFirstString.charAt(i);
            }
        }
        if(commonSuffix != "") {
            System.out.println(new StringBuilder(commonSuffix).reverse().toString());
        } else {
            System.out.println("No common suffix found.");
        }
    }
}
