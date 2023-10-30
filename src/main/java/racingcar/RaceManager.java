package racingcar;

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
}
