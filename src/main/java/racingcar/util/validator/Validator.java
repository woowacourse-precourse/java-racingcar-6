package racingcar.util.validator;

import racingcar.util.error.ErrorMessage;

public class Validator {
    private static final int LIMIT_NUMBER = 5;
    private static final int LEAST_NUMBER = 0;
    private static final String COMMA = ",";
    private static final String NULL = " ";

    public static String[] validateCars(final String input){
        checkNamesLength(split(input));
        checkIfNameIsEmpty(input);
        checkNamesNull(input);
        return split(input);
    }

    private static void checkNamesNull(String input) {
        for(String name : split(input)){
            checkNameNull(name);
        }
    }

    private static void checkNameNull(String name) {
        if(hasNameNull(name)){
            throw new IllegalArgumentException(ErrorMessage.NO_INPUT_ELEMENT.toString());
        }
    }

    private static boolean hasNameNull(String name) {
        return name.contains(NULL);
    }

    private static void checkIfNameIsEmpty(String input) {
        if(isNameEmpty(input)){
            throw new IllegalArgumentException(ErrorMessage.NO_INPUT_ELEMENT.toString());
        }
    }

    private static boolean isNameEmpty(String input) {
        return split(input).length == LEAST_NUMBER;
    }

    public static int validateTime(final String input){
        return checkTime(input);
    }

    private static int checkTime(final String input) {
        try{
            int time = Integer.parseInt(input);
            checkBoundary(time);
            return time;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.NO_NUMBER.toString());
        }
    }

    private static void checkBoundary(final int time) {
        if(isRightTime(time)){
            throw new IllegalArgumentException(ErrorMessage.LOW_NUMBER.toString());
        }
    }

    private static boolean isRightTime(final int time) {
        return time <= LEAST_NUMBER;
    }

    private static String[] split(final String input) {
        return input.split(COMMA);
    }

    private static void checkNamesLength(final String[] names) {
        for(String name : names){
            checkNameLength(name);
        }
    }

    private static void checkNameLength(final String name) {
        if(isRightLength(name)){
            throw new IllegalArgumentException(ErrorMessage.OVER_NAME_LENGTH.toString());
        }
    }

    private static boolean isRightLength(final String name) {
        return name.length() > LIMIT_NUMBER;
    }
}
