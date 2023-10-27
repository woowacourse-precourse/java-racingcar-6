package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Game {
    private Car cars;
    private int remainingSet;

    public Game(Car cars, String set) {
        this.cars = cars;
        this.remainingSet = Integer.parseInt(set);
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

    private StringBuilder getSetResult(String carName) {
        StringBuilder setResult = new StringBuilder(carName).append(" : ");

        setResult.append("-".repeat(cars.getMove(carName))).append("\n");

        return setResult;
    }
}
