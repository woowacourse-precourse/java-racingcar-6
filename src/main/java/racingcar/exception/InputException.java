package racingcar.exception;

import java.util.List;

public class InputException extends RuntimeException{

    public InputException(String message, Throwable cause) {
        super(message, new IllegalArgumentException());
    }

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

    public static void validateAttemptNum(String attemptNum) {
        try {
            int num = Integer.parseInt(attemptNum);
            if(num < 1 || num >= Integer.MAX_VALUE - 1) {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
