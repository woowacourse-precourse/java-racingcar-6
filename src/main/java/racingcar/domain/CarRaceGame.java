package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

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
        return Randoms.pickNumberInRange(0,9) >= 4;
    }

    public List<String> getWinners() {
        // 게임이 완료되면 최종 우승자 선정
        return null;
    }
}
