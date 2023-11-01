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

    public static boolean isFiveOrLessCharacter(List<String> names) {
        return names.stream().allMatch(name -> name.length() <= 5);
    }

    public static boolean isHasEmpty(List<String> names) {
        return names.stream().allMatch(name -> !name.contains(" "));
    }

    public static boolean isHasBlank(List<String> names) {
        return names.stream().allMatch(name -> !name.isEmpty());
    }
}
