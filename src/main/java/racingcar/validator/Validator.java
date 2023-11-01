package racingcar.validator;

import java.util.List;

import static racingcar.message.ErrorMessage.*;

public class Validator {

    public static void validateCarName(List<String> names){
        if(!isFiveOrLessCharacter(names)){
            throw new IllegalArgumentException(NOT_MORE_THAN_FIVE.getMessage());
        }
        if(!isHasEmpty(names)){
            throw new IllegalArgumentException(NO_SPACE_ALLOWED.getMessage());
        }
        if(!isHasBlank(names)){
            throw new IllegalArgumentException(NOT_EMPTY_ALLOWED.getMessage());
        }
    }

    public static void validateTryCnt(String cnt){
        if(!isNumeric(cnt)){
            throw new IllegalArgumentException(NOT_NUMERIC.getMessage());
        }
        if(!isPositive(cnt)){
            throw new IllegalArgumentException(NOT_POSITIVE.getMessage());
        }
    }

    private static boolean isNumeric(String input){
        return input.chars().allMatch(Character::isDigit);
    }

    private static boolean isPositive(String input){
        return Integer.parseInt(input) > 0;
    }

    private static boolean isFiveOrLessCharacter(List<String> names) {
        return names.stream().allMatch(name -> name.length() <= 5);
    }

    private static boolean isHasEmpty(List<String> names) {
        return names.stream().allMatch(name -> !name.contains(" "));
    }

    private static boolean isHasBlank(List<String> names) {
        return names.stream().allMatch(name -> !name.isEmpty());
    }
}
