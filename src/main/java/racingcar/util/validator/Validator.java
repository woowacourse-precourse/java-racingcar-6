package racingcar.util.validator;

import racingcar.util.error.ErrorMessage;

public class Validator {
    private static final int LIMIT_NUMBER = 5;
    private static final int LEAST_NUMBER = 0;

    public static String[] validateCars(String input){
        checkNamesLength(split(input));
        return split(input);
    }
    public static int validateTime(String input){
        return checkTime(input);
    }

    private static int checkTime(String input) {
        try{
            int time = Integer.parseInt(input);
            checkBoundary(time);
            return time;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.NO_NUMBER.toString());
        }
    }

    private static void checkBoundary(int time) {
        if(checkRightTIme(time)){
            throw new IllegalArgumentException(ErrorMessage.LOW_NUMBER.toString());
        }
    }

    private static boolean checkRightTIme(int time) {
        return time <= LEAST_NUMBER;
    }

    private static String[] split(String input) {
        return input.split(",");
    }

    private static void checkNamesLength(String[] names) {
        for(String name : names){
            checkNameLength(name);
        }
    }

    private static void checkNameLength(String name) {
        if(checkRightLength(name)){
            throw new IllegalArgumentException(ErrorMessage.OVER_NAME_LENGTH.toString());
        }
    }

    private static boolean checkRightLength(String name) {
        return name.length() > LIMIT_NUMBER;
    }
}
