/* Java class to insert '*' in between even numbers and '-' in between odd numbers. Zero can be ignored */
public class DashInsertChallenge {
    public static void main(String args[]) {
        String inputString = "34687902689903";
        char[] characterArray = inputString.toCharArray();
        StringBuilder insertedString = new StringBuilder();
        for(int i=1;i<characterArray.length;i++) {
            insertedString.append(characterArray[i-1]);
            int value1 = Character.getNumericValue(characterArray[i-1]);
            int value2 = Character.getNumericValue(characterArray[i]);
            if(value1 == 0) {
                continue;
            }
            if(value1%2 == 0 && value2%2 == 0) {
                insertedString.append("*");
            }
            if(value1%2 != 0 && value2%2 != 0) {
                insertedString.append("-");
            }
        }
        insertedString.append(characterArray[characterArray.length-1]);
        System.out.println("Inserted String output - " + insertedString);
    }
}
