package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    static List<String> winner = new ArrayList<>();

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

        Winner.checkWinner(Race.carRace);

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
}
