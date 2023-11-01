package racingcar.exception;

import java.util.List;

public class Validator {

    public static void validateName(List<String> nameList) throws IllegalArgumentException {
       for(String name : nameList) {
           if(name.equals("")) {
               throw new IllegalArgumentException();
           }
           if(name.length() > 5) {
               throw new IllegalArgumentException();
           }
           if(name.contains(" ")) {
               throw new IllegalArgumentException();
           }
       }
    }

    public static void validateAttemptNum(String attemptNum) throws IllegalArgumentException {
        int num = Integer.parseInt(attemptNum);
        if(num < 1 || num >= Integer.MAX_VALUE - 1) {
            throw new IllegalArgumentException();
        }
    }
}
