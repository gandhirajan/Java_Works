import java.util.Map;
import java.util.stream.Collectors;

public class CharacterOccurenceCounter {
    public static void main(String[] args) {
        String inputString = "gandhirajan";
        Map<Character,Integer> charMap = inputString.chars().boxed().collect(
                Collectors.toMap(k -> Character.valueOf((char)k.intValue()), v -> 1, Integer::sum)
        );
        System.out.println(charMap.toString());
    }
}
