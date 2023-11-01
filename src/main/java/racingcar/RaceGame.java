package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RaceGame {
    private static final int MIN_MOVE_NUMBER = 4;
    private final List<Car> cars = new ArrayList<>();
    private final int round;
    private String result = "";
    private String winner = "";

    RaceGame(List<String> carNames, int round) {
        this.setCars(carNames);
        this.round = round;
    }

    private void setCars(List<String> carNames) {
        for (String carName : carNames) {
            this.cars.add(new Car(carName));
        }
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public void roundStart() {
        for (Car car : this.cars) {
            if (getRandomNumber() >= MIN_MOVE_NUMBER) {
                car.move();
            }
        }
    }

    public void recordResult() {
        for (Car car: this.cars) {
            this.result += car.getDisplay() + "\n";
        }
        this.result += "\n";
    }

    public void setWinner() {
        int maxPosition = 0;
        for (Car car: this.cars) {
            int currentPosition = car.getPosition();
            if (currentPosition > maxPosition) {
                maxPosition = currentPosition;
                this.winner = car.getName();
            } else if (currentPosition == maxPosition) {
                this.winner += ", ";
                this.winner += car.getName();
            }
        }
    }

    public String getWinner() {
        return this.winner;
    }

    public int getRound() {
        return this.round;
    }

    public String getResult() {
        return this.result;
    }
}
