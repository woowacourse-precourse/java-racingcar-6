package util;

import config.GameProperty;
import java.util.List;
import java.util.regex.Pattern;

public class Validator {

    private Validator() {
    }

    private static final String CARNAME_REG_CONDITION = GameProperty.getCarnameRegCondition();

    private static final int MIN_GAME_TIMES = GameProperty.getMinGameTimes();
    private static final int MAX_GAME_TIMES = GameProperty.getMinGameTimes();

    public static void limitGameNumberValidator(int number) {
        if (number < MIN_GAME_TIMES || number > MAX_GAME_TIMES) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean isNumberValidator(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void nameValidator(List<String> nameList) {
        for (String name : nameList) {
            if (!Pattern.matches(CARNAME_REG_CONDITION, name)) {
                throw new IllegalArgumentException();
            }
        }
    }

}
