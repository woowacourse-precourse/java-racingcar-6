package racingcar.util;

import java.util.Arrays;

public class Validation {
    public static void isValidCarNames(String carNames){
        Arrays.stream(Parser.splitCarNames(carNames))
                .forEach(Validation::isValidCarName);
    }
    public static void isValidNumber(String number){
        isNumber(number);
    }

    private static void isValidCarName(String name){
        isEmpty(name);
        hasBlank(name);
        isValidLength(name);
    }
    private static void isEmpty(String carName){
        if(carName == null || carName.isBlank())
            throw new IllegalArgumentException();
    }
    private static void hasBlank(String carName){
        if(carName.contains(" "))
            throw new IllegalArgumentException();
    }
    private static void isValidLength(String carName){
        int carNameLength = carName.length();
        if(carNameLength <= 0 || carNameLength > 5)
            throw new IllegalArgumentException();
    }
    private static void isNumber(String count){
        if(!count.matches("^[1-9]\\d*$"))
            throw new IllegalArgumentException();
    }
}
