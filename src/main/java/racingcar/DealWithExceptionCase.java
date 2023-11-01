package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class DealWithExceptionCase {

    public static String IsNameValuable (String names) {
        for ( String name : String.valueOf(names).split(",")) {
            DealWithExceptionCase.IsVoidInName(name);
            DealWithExceptionCase.IsNameAccurate(name);
            DealWithExceptionCase.IsNameDuplicate(name);
        }
        return names;
    }

    public static void IsNameAccurate(String name) {
        if (name.length() > 5)
            throw new IllegalArgumentException();
    }

    public static void IsNameDuplicate(String name) {
        if (DuplicateTest(name)) throw new IllegalArgumentException();
    }

    public static boolean DuplicateTest(String input) {

        for (String nickname : RacingcarModel.duplicateInspection) {
            if (nickname.equals(input)) return true;
        }
        RacingcarModel.duplicateInspection.add(input);
        return false;
    }

    public static void IsVoidInName(String name) {
        if (name.equals("") || !Pattern.matches(RacingcarModel.IS_NOT_IN_VOID, name))
            throw new IllegalArgumentException();
    }

    public static void IsTurnTypeInteger(String turn) {
        if (!Pattern.matches(RacingcarModel.IS_IN_NUMBER, turn))
            throw new IllegalArgumentException();
        else {
            RacingcarModel.turn = Integer.parseInt(turn);
        }
    }

}
