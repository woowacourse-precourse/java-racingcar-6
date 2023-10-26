package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.view.OutputView;

public class RacingGame {

    private int raceCount;

    public void setRaceCount(String raceCount) {
        this.raceCount = Integer.parseInt(raceCount);
    }

    public void startRaceCount() {
        for (int i = 0; i < raceCount; i++) {
            setCarPosition();
            printCarPosition();
        }

    }

    private void setCarPosition() {
        for (Car car : Car.carList) {
            int randomNumber = setRandomNumber();
            if (randomNumber >= 4) {
                car.setPosition(1);
            }
        }
    }

    private int setRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private void printCarPosition() {
        for (Car car : Car.carList) {
            OutputView.printCarPosition(car.getName(), car.getPosition());
        }
        OutputView.divideRace();
    }
}