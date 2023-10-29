package racingcar.controller;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {

    public static List<String> parseCarName(String input) {
        List<String> carNames = new ArrayList<>();
//        if (isValidInput()) {
//            splitInput(carNames, input);
//        }
        splitInput(carNames, input);

        return carNames;
    }

    public static int triesCount(String input) {
        int tries = 0;

        //validateInput();
        tries = Integer.parseInt(input);
        return tries;
    }

    private static void splitInput(List<String> carNames, String input) {
        String[] cars = input.split(",");
        for (String car : cars) {
            carNames.add(car.trim());
        }
    }
}
