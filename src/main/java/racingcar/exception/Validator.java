package racingcar.exception;

import java.util.HashSet;

public class Validator {

    Validator() {};

    public static void name_size_check(String[] names) {
        for(int i = 0; i < names.length; i++) {
            name_size_over(names[i]);
        }
    }

    public static void name_duplication_check(String[] names) {
        HashSet<String> set = new HashSet<>();

        for(int i = 0; i < names.length; i++) {
            set.add(names[i]);
        }

        if(names.length != set.size()) throw new IllegalArgumentException(ErrorCode.DUPLICATION_NAME.getMessage());
    }

    public static void number_check(String input) {
        if(!input.matches("^[0-9]+$")) throw new IllegalArgumentException(ErrorCode.NOT_NUMBER.getMessage());
    }

    private static void name_size_over (String name) {
        if(name.length() > 5 ) throw new IllegalArgumentException(ErrorCode.OVER_NAME_SIZE.getMessage());
    }
}
