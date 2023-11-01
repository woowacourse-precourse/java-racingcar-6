package racingcar;

import java.util.List;
import java.util.ArrayList;

public class Validator {
    public static List<String> splitNames(String input) {
        String[] carNames = input.split(",");
        List<String> validCarNames = new ArrayList<>();

        for (String name : carNames) {
            name = name.trim();
            IsNull(name);
            IsIncludeBlank(name);
            IsLengthInValid(name);
            validCarNames.add(name);
        }
        return validCarNames;
    }
    private static boolean IsLengthInValid(String carName){
        if (carName.length() > 5) throw new IllegalArgumentException();
        return true;
    }
    private static boolean IsIncludeBlank(String carName){
        for (int i = 0; i < carName.length(); i++) {
            if (Character.isWhitespace(carName.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
        return true;
    }
    private static boolean IsNull(String carName){
        if (carName == null) throw new IllegalArgumentException();
        if (carName.charAt(0) == ',') throw new IllegalArgumentException();
        return true;
    }
}
