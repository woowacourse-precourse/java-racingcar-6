package racingcar.exception;

import java.util.List;

public class InputException {

    public static void isValidName(List<String> nameList)  {
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

    public static void isValidAttemptNum(String attemptNum) {
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
