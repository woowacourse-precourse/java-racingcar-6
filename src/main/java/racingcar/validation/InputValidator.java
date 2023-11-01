package racingcar.validation;

import java.util.List;
import racingcar.message.ErrorMessage;

public class InputValidator {
    public static void validateLength(String input, int limit){
        if(input.length() > limit){
            throw new IllegalArgumentException(ErrorMessage.LENGTH_LIMIT.getMessage());
        }
    }

    public static void validateNull(String input){
        if(input.equals("") || input == null){
            throw new IllegalArgumentException(ErrorMessage.INPUT_NULL.getMessage());
        }
    }

    public static void validateBlank(String input) {
        if(input.equals("") || input.isBlank()){
            throw new IllegalArgumentException(ErrorMessage.INPUT_BLANK.getMessage());
        }
    }

    public static void validateDuplicate(List<String> input){
        if (input.stream().distinct().count() != input.size()){
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NAME.getMessage());
        }
    }

    public static void validateNumber(String input){
        try{
            Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_NUMBER.getMessage());
        }
    }
}
