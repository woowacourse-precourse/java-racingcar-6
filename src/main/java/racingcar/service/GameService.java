package racingcar.service;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import racingcar.domain.Cars;
import racingcar.repository.WinnerRepository;

public class GameService {
    private final PrintService print = new PrintService();
    private final WinnerRepository winnerRepository = new WinnerRepository();

    public void run(int gameNum, Cars cars) {
        print.result();
        while (gameNum > 0) {
            addRandomNum(cars);
            print.racing(cars.size(), cars);
            gameNum--;
        }

        findWinner(cars, cars.findMaxPosition());
        print.winner(winnerRepository.winnerToString());
    }

    private void findWinner(Cars cars, int max) {
        for (int i = 0; i < cars.size(); i++) {
            if (max == cars.getGameNum(i)) {
                winnerRepository.add(cars.getName(i));
            }
        }
    }

    private void addRandomNum(Cars cars) {
        for (int i = 0; i < cars.size(); i++) {
            if (isLessThan4(pickNumberInRange(0, 9))) {
                continue;
            }
            cars.plusNum(i);
        }
    }

    private boolean isLessThan4(int random) {
        return random < 4;
    }
}