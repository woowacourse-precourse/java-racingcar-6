package racingcar.service;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import racingcar.domain.GameNum;
import racingcar.repository.CarsRepository;

public class RaceManager {
    private final PrintService print = new PrintService();
    private final CarsRepository carsRepository = new CarsRepository();
    private final GameNum gameNum = new GameNum();

    public void racing() {
        int carsSize = carsRepository.size();
        while (gameNum.isOverZero()) {
            addRandomNum(carsSize);
            print.racing(carsSize);
            gameNum.minus();
        }
    }

    private void addRandomNum(int carsSize) {
        for (int i = 0; i < carsSize; i++) {
            carsRepository.plusNum(i, pickNumberInRange(0, 9));
        }
    }
}
