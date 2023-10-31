package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.LinkedHashMap;
import racingcar.validation.InputValidation;

public class InputView {
    InputValidation inputValidation = new InputValidation();

    public LinkedHashMap<String, String> getCarNameInput() {
        String input = Console.readLine();

        String [] carNames = splitCarNameInput(input);

        LinkedHashMap<String, String> carList = changeNamesToMap(carNames);

        return carList;
    }

    private String [] splitCarNameInput(String input) {
        String [] carNames = removeSpaceFromNames(input.split(","));

        return carNames;
    }

    private String [] removeSpaceFromNames(String [] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].strip();
        }

        return carNames;
    }

    private LinkedHashMap<String, String> changeNamesToMap(String[] carNames) {
        LinkedHashMap<String, String> carList = new LinkedHashMap<>();

        for (String carName:carNames) {
            inputValidation.checkNameRight(carName, carList);

            carList.put(carName, "");
        }

        return carList;
    }

    public int getGameCountInput() {
        String input = Console.readLine();

        int totalCount = InputValidation.checkCountRight(input);

        return totalCount;
    }
}
