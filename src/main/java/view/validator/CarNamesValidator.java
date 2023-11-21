package view.validator;

import util.exception.ExceptionMessage;

public class CarNamesValidator {

    private static final String COMMA = ",";
    private static final int FIVE = 5;
    public static String[] validate(String input){
        validateCarsBlank(input);
        validateNotComma(input);
        return validateCarLength(validateCarBlank(input));
    }

    private static void validateCarsBlank(String input) {
        if (input == null || input.isBlank()) {
            ExceptionMessage.INPUT_CAR_NAMES_EMPTY.throwException();
        }
    }

    private static void validateNotComma(String input){
        if(input.contains(COMMA)){
            ExceptionMessage.INPUT_CAR_NAMES_NOT_COMMA.throwException();
        }
    }

    private static String[] validateCarBlank(String input){
        String[] carNames = input.split(COMMA);

        for (String name : carNames) {
            if (name.trim().isEmpty()) {
                ExceptionMessage.INPUT_CAR_NAMES_EMPTY.throwException();
            }
        }
        return carNames;
    }

    private static String[] validateCarLength(String[] cars){
        for (String name : cars) {
            if (name.trim().length() > FIVE) {
                ExceptionMessage.INPUT_CAR_NAME_LENGTH_EXCEED.throwException();
            }
        }
        return cars;
    }
}
