package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

/*
 *   플레이어의 정보를 담당
 * */

public class GamePlayer {
    private final List<Car> cars = new ArrayList<>();

    private GamePlayer(List<String> carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public static GamePlayer from(List<String> carNames) {
        return new GamePlayer(carNames);
    }

    public void moveCarsByCount(int count) {
        for (int i = 0; i < count; i++) {
            moveCars();
            System.out.println();
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public GameRank toGameRank() {
        return new GameRank(cars);
    }

    public int findBestRecord() {
        int bestRecord = 0;
        for (Car car : cars) {
            bestRecord = Car.findBiggerRecord(bestRecord, car);
        }
        return bestRecord;
    }
}
