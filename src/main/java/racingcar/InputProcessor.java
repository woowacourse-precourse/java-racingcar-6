package racingcar;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class InputProcessor {

    public static ArrayList<String> carNameInputProcess(String input) {
        checkNull(input);

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

    public static int tryCountInputProcess(String input) {
        try {
            checkNull(input);

            int tryCount = Integer.parseInt(input);
            if (tryCount < 1) {
                throw new IllegalArgumentException("Try count must be greater than 0. \nerrorVar : " + input);
            }
            return tryCount;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid number format. \nerrorVar : " + input);
        }
    }

    public static String verifyCarNameOver5(String input) {
        if (input.length() > 5) {
            throw new NoSuchElementException("String index out of range: 5 \nerrorVar : " + input);
        }
        return input;
    }

    public static String checkNull(String input) {
        if (input == null || input.isEmpty()) {
            throw new NullPointerException("String is null or empty. \nerrorVar : " + input);
        }
        return input;
    }
}
