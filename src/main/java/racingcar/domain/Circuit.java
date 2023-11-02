package racingcar.domain;


import java.util.List;

public class Circuit {

    public void race(List<Car> carNames) {
        for (Car car : carNames) {
            if (Car.isMoved()) {
                car.increaseMovingCount();
            }
        }
    }
}
