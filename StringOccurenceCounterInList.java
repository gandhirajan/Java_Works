import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StringOccurenceCounterInList {
    public static void main(String args[]) {
        List<String> stringList = new ArrayList<>();
        stringList.add("one");
        stringList.add("two");
        stringList.add("three");
        stringList.add("one");
        stringList.add("one");
        stringList.add("four");
        Map<String,Long> processedMap = stringList.stream().collect(
                Collectors.groupingBy(e->e,Collectors.counting())
        );
        System.out.println(processedMap.toString());

    }
}
