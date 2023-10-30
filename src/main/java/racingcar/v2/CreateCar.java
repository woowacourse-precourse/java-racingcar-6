package racingcar.v2;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.Map;

/**
 * 예외 처리를 별도로 빼면 코드 관리가 편하지만 간단한 예외 처리는 메서드 내부에서 처리하는 것이 좋다.
 * 장단점이 모두 있으니 2주차 목표에 맞게 함수를 분리해서 구현.
 */

public class CreateCar {
    public String input() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return input;
    }

    public String[] carName(String input) {
        String[] carNames = input.split(",");
        checkCarCount(carNames);
        for (String carName : carNames) {
            checkNameLength(carName.trim());  // 이름의 길이 검사
        }
        return carNames;
    }

    public int carCount(Map stateMap) {
        int carCount = stateMap.size();
        return carCount;
    }

    public Map<String, Integer> stateMap(String[] carNames) {
        Map<String, Integer> stateMap = new HashMap<>();
        for (String car : carNames) {
            stateMap.put(car.trim(), 0);
        }
        return stateMap;
    }

    private void checkCarCount(String[] carNames) {
        if (carNames.length > 10 || carNames.length < 2) {
            throw new IllegalArgumentException("자동차는 2대 이상, 10대 이하만 가능합니다.");
        }
    }

    public void checkNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

}
