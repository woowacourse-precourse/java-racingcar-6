package racingcar.Controller;

import java.util.List;

public class InputValidator {
    public static void checkCarNames(List<String> inputNames){
        for(String name: inputNames) {
            if(name.length() > 5) {
                throw new IllegalArgumentException("Car name is too long");
            }
            if(name.isEmpty()) {
                throw new IllegalArgumentException("Car name is too short");
            }
        }
    }

    public static int checkTurn(String turnInput){
        try {
            int turns = Integer.parseInt(turnInput);
            if (turns < 1) {
               throw new IllegalArgumentException("Number of turn must be at least 1");
            }
            return turns;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid turn input");
        }
    }
}
