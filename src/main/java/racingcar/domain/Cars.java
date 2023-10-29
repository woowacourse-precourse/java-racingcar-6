package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(String[] carNames) {
        validateDuplicatedCarName(carNames);
        Arrays.stream(carNames).forEach(name -> cars.add(new Car(name)));
    }

    public void validateDuplicatedCarName(String[] carNames) {
        if (Arrays.stream(carNames).distinct().count() != carNames.length) {
            throw new IllegalArgumentException("중복된 이름이 입력되었습니다.");
        }
    }


}
