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

    public String[] carName(String input) {
        String[] carName = input.split(",");
        return carName;
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
