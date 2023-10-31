package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.output.GameOutput;

public class RacingGame {
    private List<Car> cars;
    private int iterationNumber;

    public RacingGame(List<String> carNames, int iterationNumber) {
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
        GameOutput gameOutput = new GameOutput();
        gameOutput.initialize();

        for (int i = 0; i < iterationNumber; i++) {
            moveCars();
            gameOutput.currentStatus(cars);
        }
        gameOutput.winners(getWinners());
    }

    public void moveCars() {
        for (Car car : cars) {
            if (isForwardCondition()) {
                car.moveForward();
            }
        }
    }

    public boolean isForwardCondition() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    public List<String> getWinners() {
        int maxForwardCount = 0;
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getForwardCount() > maxForwardCount) {
                maxForwardCount = car.getForwardCount();
                winners.clear();
                winners.add(car.getName());
            } else if (car.getForwardCount() == maxForwardCount) {
                winners.add(car.getName());
            }
        }

        return winners;
    }
}
