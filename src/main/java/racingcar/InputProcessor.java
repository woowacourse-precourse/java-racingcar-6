package racingcar;

import java.util.ArrayList;
import java.util.Collections;

public class InputProcessor {

    public static ArrayList<String> carNameInputProcess(String input) {
        ArrayList<String> carNames = new ArrayList<>();
        String[] splitInput = input.split(",");
        for (String carName : splitInput) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            carNames.add(carName);
        }
        return carNames;
    }
}
