package racingcar.util;

import java.util.List;

import static racingcar.util.Checker.validateCarName;
import static racingcar.util.Checker.validateInput;

public class Utils {

    public static String getStringFormat(List<String> input){
        StringBuilder result = new StringBuilder();

        if(input.size() == 1) return input.get(0);

        for(String item : input){
            result.append(item).append(",");
        }

        return result.toString();
    }

    public static String[] parseCarName(String input) {

        String[] names = input.split(",");

        for (String name : names) {
            validateCarName(name);
        }
        return names;
    }

    public static String setFormat(String input){
        String output = "";
        output = removeGap(input);
        validateInput(input);
        return output;
    }
    public static String removeGap(String input){
        return input.trim();
    }
}
