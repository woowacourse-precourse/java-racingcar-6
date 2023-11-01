package racingcar;

import java.util.regex.Pattern;
public class DealWithExceptionCase {
    public static void IsNameAccurate(String name) {
        if (name.length() > 5)
            throw new IllegalArgumentException();
    }
    public static void IsNameDuplicate(String name) {
        if (RacingcarModel.duplicateInspection.contains(name))
            throw new IllegalArgumentException();
        else {
            RacingcarModel.duplicateInspection.add(name);
        }
    }
    public static void IsVoidInName(String name) {
        if (name.equals("") || Pattern.matches(RacingcarModel.IS_NOT_IN_VOID, name))
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
