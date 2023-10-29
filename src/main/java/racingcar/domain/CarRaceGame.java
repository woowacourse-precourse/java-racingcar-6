package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarRaceGame {
    private List<Car> cars;
    private int iterationNumber;

    public CarRaceGame(List<String> carNames, int iterationNumber) {
        initializeCars(carNames);
        this.iterationNumber = iterationNumber;
    }

    public void initializeCars(List<String> carNames) {
        cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public void playGame() {
        for (int i = 0; i < iterationNumber; i++) {
            moveCars();
            // output result
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            if (isForwardCondition()) {
                car.moveForward();
            }
        }
    }

    public boolean isForwardCondition() {
        // 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4이상일 경우
        return true;
    }

    public List<String> getWinners() {
        // 게임이 완료되면 최종 우승자 선정
        return null;
    }
}
