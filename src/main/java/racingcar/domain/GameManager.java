package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    static List<String> winner = new ArrayList<>();

    int maxValue = Integer.MIN_VALUE;

    public GameManager() {
        InputValue inputValue = new InputValue();
        playGame();
    }

    private void playGame() {
        Race.makeCars(InputValue.carName);

        for (int i = 0; i < InputValue.count; i++) {
            checkForwardStop(Race.carRace);
            ResultPrinter.printCourse(Race.carRace);
        }

        checkWinner(Race.carRace);

        if (winner.size() > 1) {
            ResultPrinter.printWinners(winner);
        } else {
            ResultPrinter.printWinner(winner.get(0));
        }
    }

    private void checkForwardStop(List<Car> car) {
        for (int i = 0; i < car.size(); i++) {
            int randomNum = getRandomNum();

            decideCallForwardStop(car.get(i), randomNum);
        }
    }

    private int getRandomNum() {
        return Randoms.pickNumberInRange(0,9);
    }

    private void decideCallForwardStop(Car car, int RandomNum) {
        if (RandomNum >= 4) {
            car.forward();
        } else {
            car.stop();
        }
    }

    private void checkWinner(List<Car> list) {
        for (Car car : list) {
            addWinner(car, maxValue);
        }
    }

    private int getPosition(Car car) {
        return car.position;
    }

    private void addWinner(Car car, int maxValue) {
        if (winner.isEmpty() && getPosition(car) > maxValue) {
            winner.add(car.carName);
            this.maxValue = car.position;
        } else if (!winner.isEmpty() && getPosition(car) > maxValue) {
            winner.clear();
            winner.add(car.carName);
            this.maxValue = car.position;
        } else if (!winner.isEmpty() && getPosition(car) == maxValue) {
            winner.add(car.carName);
        }
    }
}
