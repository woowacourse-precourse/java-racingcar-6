package racingcar.service;

import java.util.List;

public class validation {
    public static void nameLengthExcept(List<String> names){
        names.stream()
                .forEach(name -> lengthExcept(name));
    }

    private static void lengthExcept(String name){
        if(name.length() >= 5){
            throw new IllegalArgumentException();
        }
    }

    public static void numCheck(String tryNum){
        try {
            int checkIntNUm = Integer.parseInt(tryNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
