package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private final List<Car> cars;
    private final int tryCount;

    public Race(List<Car> cars, int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public void start() {
        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            for (Car car: cars) {
                car.move();
            }

            for (Car car: cars) {
                System.out.println(car.getName() + " : " + car.getPositionBar());
            }
        }
    }

    public List<String> getWinners() {
        int maxPosition = 0;
        for (Car car: cars) {
            int position  = car.getPosition();
            if (position > maxPosition) maxPosition = position;
        }

        List<String> winners = new ArrayList<>();
        for (Car car: cars) {
            if (car.getPosition() == maxPosition) winners.add(car.getName());
        }

        return winners;
    }
}
