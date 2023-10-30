package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.Map;

public class Input {
    public Map<String, Integer> carNames() {
        Map<String, Integer> carNames = new HashMap<>();
        for (String carName : Console.readLine().split(",")) {
            // 예외 처리 - 이름이 5자 이하인지
            if (carName.length() > 5) throw new IllegalArgumentException();
            carNames.put(carName, 0);
        }
        return carNames;
    }

    public int tryCount() {
        return Integer.parseInt(Console.readLine());
    }
}