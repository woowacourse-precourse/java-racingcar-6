package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private Car cars;
    private int remainingSet;
    private int maxMove;

    public Game(Car cars, String set) {
        this.cars = cars;
        this.remainingSet = Integer.parseInt(set);
        maxMove = 0;
    }

    public boolean isContinue() {
        return remainingSet > 0;
    }

    public StringBuilder playSet() {
        StringBuilder setResult = new StringBuilder();

        for (String carName : cars.getCarNameSet()) {
            int distance = cars.getMove(carName);

            if (canGo()) {
                cars.updateMove(carName, distance + 1);

                updateMaxMove(carName);
            }

            setResult.append(getSetResult(carName));
        }

        remainingSet--;

        return setResult;
    }

    private boolean canGo() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);

        return randomNumber >= 4;
    }

    private void updateMaxMove(String carName) {
        if (cars.getMove(carName) > maxMove) {
            maxMove = cars.getMove(carName);
        }
    }

    private StringBuilder getSetResult(String carName) {
        StringBuilder setResult = new StringBuilder(carName).append(" : ");

        setResult.append("-".repeat(cars.getMove(carName))).append("\n");

        return setResult;
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
