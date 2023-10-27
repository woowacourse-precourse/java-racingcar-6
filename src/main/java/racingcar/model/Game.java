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

    public void playSet() {
        for (String carName : cars.getCarNameSet()) {
            int distance = cars.getMove(carName);

            if (canGo()) {
                cars.updateMove(carName, distance + 1);
            }
        }

        remainingSet--;
    }

    private boolean canGo() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);

        return randomNumber >= 4;
    }
}
