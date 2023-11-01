package racingcar;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RacingGame {

    public void startRacing() {
        List<Car> cars = Display.inputCars();
        Utils.checkNameOverFive(cars);
        int trial = Display.inputTrial();

        while(trial-- > 0) {
            getResultOfTurn(cars);
            Display.printCurrentPositions(cars);
        }

        List<String> winners = findWinners(cars);
        Display.printFinalWinners(winners);
    }

    private List<String> findWinners(List<Car> cars) {
        int maxLen = 0;
        for(Car car : cars) {
            maxLen = Math.max(maxLen, car.getPosition());
        }

        List<String> winners = new ArrayList<>();
        for(Car car : cars) {
            if(car.getPosition() == maxLen) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private void getResultOfTurn(List<Car> cars) {
        for(Car car : cars) {
            if(canMove()) {
                car.addPosition();
            }
        }
    }

    private boolean canMove() {
        int result = pickNumberInRange(0, 9);
        if(result >= 4) {
            return true;
        }
        return false;
    }
}
