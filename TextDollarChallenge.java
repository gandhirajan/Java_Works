import java.util.ArrayList;
import java.util.List;

public class TextDollarChallenge {

    private static final int BASE_DIVISOR = 1000;

    private static final String[] BASE_NUMBER_WORDS = {
            "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten ",
            "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ",
            "Nineteen ", "Twenty "
    };

    private static final String[] BASE_TEN_MULTIPLE_WORDS = {"Ten ", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};

    private static final String[] BASE_RANGE_WORDS = {
            "",
            "Thousand ",
            "Million ",
            "Billion "
    };


    private List<Integer> parsedNumbersList = new ArrayList<>();

    public static void main(String[] args) {
        TextDollarChallenge dollarToText = new TextDollarChallenge();
        System.out.println("MAX INT in words: " + dollarToText.prettyPrintCurrency(Integer.MAX_VALUE));
        System.out.println("30 in words: " + dollarToText.prettyPrintCurrency(30));
        System.out.println("31 in words: " + dollarToText.prettyPrintCurrency(31));
    }

    private String prettyPrintCurrency(int amount) {
        parsedNumbersList.clear();
        if(amount < 0) throw new RuntimeException("Invalid Dollar value");
        parseBaseNumbers(amount);

        if(parsedNumbersList.isEmpty()) return "Zero Dollar";

        StringBuilder dollarInWords = new StringBuilder();
        for(int i = parsedNumbersList.size() - 1; i >= 0; i--) {
            dollarInWords.append(convertHundredMultiplesToWords(parsedNumbersList.get(i)) + BASE_RANGE_WORDS[i]);
        }

        return dollarInWords.toString() + "Dollars";
    }

    private void parseBaseNumbers(int amount) {
        if (amount == 0) return;

        int quotient = amount / BASE_DIVISOR;
        int mod = amount % BASE_DIVISOR;

        parsedNumbersList.add(mod);

        if (quotient > BASE_DIVISOR) {
            parseBaseNumbers(quotient);
        } else if (quotient > 0){
            parsedNumbersList.add(quotient);
        }

    }

    private String convertHundredMultiplesToWords(int amount) {
        if(amount == 0) {
            return "";
        }
        if (amount > 0 && amount <= 20) {
            return BASE_NUMBER_WORDS[amount - 1];
        } else if (amount < 100) {
            int mod = amount % 10;
            int quotient = amount / 10;
            if(mod > 0) {
                return BASE_TEN_MULTIPLE_WORDS[quotient - 1] + BASE_NUMBER_WORDS[mod - 1];
            } else {
                return BASE_TEN_MULTIPLE_WORDS[quotient - 1];
            }

        }else{
            int mod = amount % 100;
            int quotient = amount / 100;
            return BASE_NUMBER_WORDS[quotient - 1] + "Hundred and " + convertHundredMultiplesToWords(mod);
        }
    }
}