package racingcar.model;

import racingcar.view.InputView;

import java.util.HashMap;
import java.util.Map;

public class RacingCar {
    public static Map<String, Integer> saveRacingCar() {
        String[] inputRacingCar = InputView.getCarName().split(",");
        Map<String, Integer> racingCar = new HashMap<>();
        for (String carName : inputRacingCar) {
            if (carName.trim().length() > 5) {
                throw new IllegalArgumentException("각 자동차 이름은 5글자 이하만 가능합니다.");
            }
            racingCar.put(carName, 0);
        }
        return racingCar;
    }
}
