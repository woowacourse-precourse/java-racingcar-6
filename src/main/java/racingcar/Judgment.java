package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Judgment {
    // 차 이름, 전진 모양, 횟수
    List<Car> cars = new ArrayList<>();
    Car maxMovement = cars.stream().max(Comparator.comparing(Car::getForwardMovementNumber)).get();
}
