package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingCars {
    private static final String DUPLICATE_CAR_NAME_ERROR = "[ERROR] : 중복되지 않은 자동차 이름을 입력해주세요.";
    private final List<Car> racingCars;

    public RacingCars(List<String> carNames) {
        this.racingCars = carNames.stream()
                .map(Car::new)
                .toList();
    }
    public int getSize(){
        return racingCars.size();
    }

}
