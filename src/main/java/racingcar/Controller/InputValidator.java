package racingcar.Controller;

import java.util.List;

public class InputValidator {
    public static void checkCarNames(List<String> inputNames){
        for(String name: inputNames) {
            if(name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static int checkTurn(String turnInput){
        try {
            return Integer.parseInt(turnInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
