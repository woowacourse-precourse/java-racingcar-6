package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RaceManager {
    private List<Car> cars;
    private int rounds;

    public RaceManager(List<Car> cars, int rounds) {
        this.cars = cars;
        this.rounds = rounds;
    }

    public void race() {
        for (int i = 0; i < rounds; i++) {
            for (Car car: cars) {
                car.move();
            }
            // 각 라운드 결과 출력 예정
        }
    }

    public List<Car> getWinners() {
        int maxPosition = -1;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }

        return winners;
    }
}
