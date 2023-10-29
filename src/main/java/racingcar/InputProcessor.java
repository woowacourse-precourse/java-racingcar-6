package racingcar;

import java.util.ArrayList;

public class InputProcessor {

    public static ArrayList<String> carNameInputProcess(String input) {
        if (input == null || input.isEmpty()) {
            throw new NullPointerException("String is null or empty. \nerrorVar : " + input);
        }
        ArrayList<String> carNames = new ArrayList<>();
        if(input.contains(",")) {
            String[] splitInput = input.split(",");
            for (String carName : splitInput) {
                carName = verifyCarNameOver5(carName);
                carNames.add(carName);
            }
        } else {
            input = verifyCarNameOver5(input);
            carNames.add(input);
        }
        return carNames;
    }

    public static String verifyCarNameOver5(String input) {
        if (input.length() > 5) {
            throw new StringIndexOutOfBoundsException("String index out of range: 5 \nerrorVar : " + input);
        }
        return input;
    }
    
}
