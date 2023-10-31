package racingcar.v3;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.Map;

public class CreateCar {
    public String input() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return input;
    }

    public String[] splitCarNames(String input) {
        String[] carNames = input.split(",");
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].trim();
            if (carNames[i].isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상이어야 합니다.");
            }
        }
        return carNames;
    }


    public String[] validateCarNames(String[] carNames) throws IllegalArgumentException {
        validateCarCount(carNames);
        validateCarNameLength(carNames);
        return carNames;
    }

    public Map<String, Integer> stateMap(String[] carNames) {
        Map<String, Integer> stateMap = new HashMap<>();
        for (String carName : carNames) {
            stateMap.put(carName, 0);
        }
        return stateMap;
    }


    public void validateCarCount(String[] carNames) throws IllegalArgumentException {
        if (carNames.length < 2 || carNames.length > 10) {
            throw new IllegalArgumentException("자동차의 수는 2대 이상 10대 이하만 가능합니다.");
        }
    }

    public void validateCarNameLength(String[] carNames) throws IllegalArgumentException {
        for (String carName : carNames) {
            if (carName.length() == 0 || carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다. 입력된 이름: " + carName);
            }
        }
    }

}
