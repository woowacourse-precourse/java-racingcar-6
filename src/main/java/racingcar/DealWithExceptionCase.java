package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class DealWithExceptionCase {

    public static String IsNameValuable (String names) {
        RacingcarModel.duplicateInspection = new ArrayList<String>();
        for ( String name : String.valueOf(names).split(",")) {
            IsVoidInName(name);
            IsNameAccurate(name);
            IsNameDuplicate(name);
        }
        return names;
    }

    public static void IsNameAccurate(String name) {
        if (name.length() > 5)
            throw new IllegalArgumentException();
    }

    public static void IsNameDuplicate(String name) {
        for (String nickname : RacingcarModel.duplicateInspection) {
            if (nickname.equals(name)) throw new IllegalArgumentException();
        }
        RacingcarModel.duplicateInspection.add(name);
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
