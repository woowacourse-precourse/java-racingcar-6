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

    public void run() {
        print.result();
        while (gameNum.isOverZero()) {
            addRandomNum();
            print.racing(carsRepository.size());
            gameNum.minus();
        }

        findWinner(carsRepository.findMaxPosition());
        print.winner(winnerRepository.winnerToString());
        carsRepository.reset();
    }

    private void findWinner(int max) {
        for (int i = 0; i < carsRepository.size(); i++) {
            if (max == carsRepository.getGameNum(i)) {
                winnerRepository.add(carsRepository.getName(i));
            }
        }
    }

    private void addRandomNum() {
        for (int i = 0; i < carsRepository.size(); i++) {
            if (isLessThan4(pickNumberInRange(0, 9))) {
                continue;
            }
            carsRepository.plusNum(i);
        }
    }

    private boolean isLessThan4(int random) {
        return random < 4;
    }
}