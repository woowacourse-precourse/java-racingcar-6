package racingcar.validator;

public class Exception {
    public static void illegalArgument(String errorMessage){
        throw new IllegalArgumentException(errorMessage);
    }
}
