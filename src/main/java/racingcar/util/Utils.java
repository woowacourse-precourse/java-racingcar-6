package racingcar.util;

import java.util.List;

import static racingcar.util.Checker.validateCarName;

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
}
