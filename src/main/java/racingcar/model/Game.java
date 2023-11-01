package racingcar.model;

import static racingcar.constant.Constant.END_CONDITION;
import static racingcar.constant.Constant.INIT_MOVE;
import static racingcar.constant.Constant.MAX_RANDOM_NUMBER;
import static racingcar.constant.Constant.MIN_RANDOM_NUMBER;
import static racingcar.constant.Constant.MOVABLE_RANDOM_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Car cars;
    private int remainingSet;
    private int maxMove;

    public Game(Car cars, String set) {
        this.cars = cars;
        this.remainingSet = Integer.parseInt(set);
        maxMove = INIT_MOVE;
    }

    public boolean isContinue() {
        return remainingSet > END_CONDITION;
    }

    public void playSet() {
        for (String carName : cars.getCarNameSet()) {
            int distance = cars.getMove(carName);

            if (canGo()) {
                cars.updateMove(carName, distance + 1);

                updateMaxMove(carName);
            }
        }

        remainingSet--;
    }

    private boolean canGo() {
        int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);

        return randomNumber >= MOVABLE_RANDOM_NUMBER;
    }

    private void updateMaxMove(String carName) {
        if (cars.getMove(carName) > maxMove) {
            maxMove = cars.getMove(carName);
        }
    }

    public Car getCars() {
        return cars;
    }

    public List<String> getWinnerList() {
        List<String> winner = new ArrayList<>();

        for (String carName : cars.getCarNameSet()) {
            if (cars.getMove(carName) == maxMove) {
                winner.add(carName);
            }
        }

        return winner;
    }
}
