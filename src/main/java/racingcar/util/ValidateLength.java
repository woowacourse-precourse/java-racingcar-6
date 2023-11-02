package racingcar.util;

public class ValidateLength {
    public ValidateLength(){}

    public static void check(int max, String value){
        if(1 < value.length() || value.length() > max){
            throw new IllegalArgumentException();
        }
    }

}
