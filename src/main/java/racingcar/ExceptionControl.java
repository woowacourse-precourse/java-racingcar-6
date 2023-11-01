package racingcar;

import java.util.List;

public class ExceptionControl {
    public static void checkCarNameInput(List<String> cars) {
        for (int i = 0; i < cars.size(); i++) {
            String car = cars.get(i);
            if (car.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }
}
