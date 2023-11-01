package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class DealWithExceptionCase {

    public static String IsNameValuable (String names) {
        List<String> duplicateInspection = new ArrayList<String>();
        for (String name : String.valueOf(names).split(",")) {
//            System.out.println(duplicateInspection+name);
            for (String nickname : duplicateInspection) {
                if (nickname.equals(name)) throw new IllegalArgumentException();
            }
            duplicateInspection.add(name);
        }
        for ( String name : String.valueOf(names).split(",")) {
            DealWithExceptionCase.IsVoidInName(name);
            DealWithExceptionCase.IsNameAccurate(name);
        }
        return names;
    }

    public static void IsNameAccurate(String name) {
        if (name.length() > 5)
            throw new IllegalArgumentException();
    }

//    public static void IsNameDuplicate(String name) {
//        List<String> duplicateInspection = new ArrayList<String>();
//        for (String nickname : duplicateInspection) {
//            if (nickname.equals(name)) throw new IllegalArgumentException();
//            duplicateInspection.add(name);
//            System.out.println(duplicateInspection);
//        }
//    }


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
