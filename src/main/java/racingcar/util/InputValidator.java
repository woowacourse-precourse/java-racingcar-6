package racingcar.util;

public class InputValidator {
    private static final int MAX_LENGTH = 5;
    public Boolean isMaxLengthValid(String input){
        return input.length() <= MAX_LENGTH;
    }
}
