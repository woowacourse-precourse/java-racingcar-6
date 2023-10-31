package racingcar.util.validator;

import racingcar.util.error.ErrorMessage;

public class Validator {
    private static final int LIMIT_NUMBER = 5;
    private static final int LEAST_NUMBER = 0;
    private static final String COMMA = ",";

    public static String[] validateCars(final String input){
        checkNamesLength(split(input));
        return split(input);
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
        if(checkRightTIme(time)){
            throw new IllegalArgumentException(ErrorMessage.LOW_NUMBER.toString());
        }
    }

    private static boolean checkRightTIme(final int time) {
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
        if(checkRightLength(name)){
            throw new IllegalArgumentException(ErrorMessage.OVER_NAME_LENGTH.toString());
        }
    }

    private static boolean checkRightLength(final String name) {
        return name.length() > LIMIT_NUMBER;
    }
}
