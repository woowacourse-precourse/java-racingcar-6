package racingcar.service;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import racingcar.domain.GameNum;
import racingcar.repository.CarsRepository;

public class RaceManager {
    private final PrintService print = new PrintService();
    private final CarsRepository carsRepo = new CarsRepository();
    private final GameNum gameNum = new GameNum();

    public void racing() {
        int carsSize = carsRepo.size();

        while (gameNum.isOverZero()) {
            inputRandomNum(carsSize);
            print.racing(carsSize);
            gameNum.minus();
        }
    }

    private void inputRandomNum(int carsSize) {
        for (int i = 0; i < carsSize; i++) {
            carsRepo.plusNum(i, pickNumberInRange(0, 9));
        }
    }
}
