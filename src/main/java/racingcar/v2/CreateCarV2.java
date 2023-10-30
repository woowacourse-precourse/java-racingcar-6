package racingcar.v2;

import camp.nextstep.edu.missionutils.Console;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CreateCarV2 {
    public String input() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return input;
    }
    // TODO: 자동차 이름 예외 처리. 5자 초과, 중복, 공백
    public String[] carName(String input) {
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            if (carName.trim().length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
        return carNames;
    }

    public Map<String, Integer> stateMap(String input) {
        String[] carNames = carName(input);
        Map<String, Integer> stateMap = new HashMap<>();
        for (String car : carNames) {
            stateMap.put(car.trim(), 0);
        }
        return stateMap;
    }

    public int carCount(Map stateMap) {
        int carCount = stateMap.size();
        return carCount;
    }

}
