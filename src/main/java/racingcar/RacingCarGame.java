package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class RacingCarGame {

    HashMap<String, Integer> cars = new LinkedHashMap<>();



    public void inputUserCarName() {
        String userInput = Console.readLine();
        validateInputNotEmpty(userInput);

        String[] carNames = userInput.split(",");
        validateCarNames(carNames);

        for (String carName : carNames) {
            cars.put(carName, 0);
        }

    }
    private static void validateInputNotEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException("입력이 없습니다.");
        }
    }

    private void validateCarNames(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("차의 이름은 5글자 이하이어야 합니다.");
            }
        }
    }
}