package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Referee {

    public Referee() {
    }

    public List<Car> getWinnerCars(List<Car> cars) {
        assertNotEmptyCars(cars);

        cars.sort((car1, car2) -> Integer.compare(car2.getPosition(), car1.getPosition()));
        int maxPosition = cars.get(0).getPosition();
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(new Car(car));
            }
        }

        return winners;
    }

    private void assertNotEmptyCars(List<Car> cars) {
        if (cars == null) {
            throw new NullPointerException("[Referee] null은 허용하지 않습니다.");
        }
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("[Referee] 1 개 이상의 차가 필요 합니다.");
        }
    }
}
