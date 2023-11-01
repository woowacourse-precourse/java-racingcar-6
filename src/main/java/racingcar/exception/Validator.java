package racingcar.exception;

import java.util.HashSet;
import java.util.List;

public class Validator {

    Validator() {};

    public static void name_size_check(List<String> names) {
        for(int i = 0; i < names.size(); i++) {
            name_size_over(names.get(i));
        }
    }

    public static void name_duplication_check(List<String> names) {
        HashSet<String> set = new HashSet<>();

        for(int i = 0; i < names.size(); i++) {
            set.add(names.get(i));
        }

        if(names.size() != set.size()) throw new IllegalArgumentException(ErrorCode.DUPLICATION_NAME.getMessage());
    }

    public static void name_null_check(String input) {
        if(input.length() == 0 || input.startsWith(",")) throw new IllegalArgumentException(ErrorCode.NAME_NULL.getMessage());
    }

    public static void character_check(String input) {
        if(!input.matches("^[ㄱ-ㅎ가-힣a-zA-Z,]*$")) throw new IllegalArgumentException(ErrorCode.NOT_STRING.getMessage());
    }

    public static void number_check(String input) {
        if(!input.matches("^[0-9]+$")) throw new IllegalArgumentException(ErrorCode.NOT_NUMBER.getMessage());
    }

    private static void name_size_over (String name) {
        if(name.length() > 5 ) throw new IllegalArgumentException(ErrorCode.OVER_NAME_SIZE.getMessage());
    }
}
