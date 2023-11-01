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
            System.out.println();
        }
    }

    public List<String> getWinners() {
        int maxPosition = findMaxPosition();
        return findWinners(maxPosition);
    }

    public int findMaxPosition() {
        int maxPosition = 0;
        for (Car car: cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public List<String> findWinners(int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car: cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
