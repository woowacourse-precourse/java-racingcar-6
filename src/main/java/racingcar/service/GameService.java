package racingcar.service;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import racingcar.domain.GameNum;
import racingcar.repository.CarsRepository;
import racingcar.repository.WinnerRepository;

public class GameService {
    private final PrintService print = new PrintService();
    private final WinnerRepository winnerRepository = new WinnerRepository();
    private final CarsRepository carsRepository = new CarsRepository();
    private final GameNum gameNum = new GameNum();
    int carsSize = 0;

    public void run() {
        print.result();
        carsSize = carsRepository.size();
        while (gameNum.isOverZero()) {
            addRandomNum();
            print.racing(carsSize);
            gameNum.minus();
        }

        findWinner(carsRepository.findMaxPosition());
        print.winner(winnerRepository.winnerToString());
    }

    private void findWinner(int max) {
        for (int i = 0; i < carsSize; i++) {
            if (max == carsRepository.getGameNum(i)) {
                winnerRepository.add(carsRepository.getName(i));
            }
        }
    }

    private void addRandomNum() {
        for (int i = 0; i < carsSize; i++) {
            carsRepository.plusNum(i, pickNumberInRange(0, 9));
        }
    }
}