package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static racingcar.constants.StringStore.*;

public class Input {
    public String inputNames() {
        System.out.println(INPUT_CAR_NAMES);
        String inputCarString = Console.readLine();
        return inputCarString;
    }
    public List<String> stringToList(String inputCarString) {
        List<String> carNames = new ArrayList<>();
        String[] namesArray = inputCarString.split(",");
        for (String name : namesArray) {
            String trimmedName = name.trim();
            if (trimmedName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
            carNames.add(trimmedName);
        }
        return carNames;
    }
    public int inputTryCount() {
        System.out.println(INPUT_TRY_COUNT);
        String inputTryString = Console.readLine();
        int inputTry = Integer.parseInt(inputTryString);
        return inputTry;
    }
}
