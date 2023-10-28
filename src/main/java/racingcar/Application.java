package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.Map;

public class Application {
    static Map<String, String> forwardMap;

    public static void main(String[] args) {
        forwardMap = new HashMap<>();
        // 1. 자동차 이름 입력받기
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        getCars();
    }

    static void getCars() {
        String carNames = Console.readLine();
        for (String car : carNames.split(",")) {
            String carName = car.trim();
            if (carName.length() > 5 || forwardMap.containsKey(carName)) {
                throw new IllegalArgumentException();
            }
            forwardMap.put(carName, "");
        }
    }
}
