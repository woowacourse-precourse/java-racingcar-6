package racingcar.service;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import racingcar.domain.Cars;
import racingcar.domain.GameNum;

public class RaceManager {
    private final PrintService print = new PrintService();
    private final GameNum gameNum = new GameNum();
    private final Cars cars = Cars.create();

    public void racing() {
        int carsSize = cars.size();

        while (gameNum.isOverZero()) {
            inputRandomNum(carsSize);
            print.racing(carsSize);
            gameNum.minus();
        }
    }

    public void inputRandomNum(int carsSize) {
        for (int i = 0; i < carsSize; i++) {
            cars.plusNum(i, pickNumberInRange(0, 9));
        }
    }
}
