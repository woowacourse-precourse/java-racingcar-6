package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingGameService {
    Map<String, String> carMovements = new HashMap<>();

    public void inputCarNames() {
        String input = Console.readLine();
        for (String car : input.split(",")) {
            String carName = car.trim();
            if (carName.length() > 5 || carMovements.containsKey(carName)) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하의 길이로 쉼표(,)를 기준으로 구분해주시고 이미 등록된 자동차 입니다.");
            }
            carMovements.put(carName, "");
        }
    }

    int getInputAttempts() {
        return Integer.parseInt(Console.readLine());
    }

    void playRound() {
        for (String car : carMovements.keySet()) {
            System.out.print(car + " : ");
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                carMovements.put(car, carMovements.get(car) + "-");
            }
            System.out.println(carMovements.get(car));
        }
        System.out.println();
    }

}
