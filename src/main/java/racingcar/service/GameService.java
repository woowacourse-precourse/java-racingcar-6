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

        findWinner2(cars, cars.findMaxPosition());
        print.winner(cars);
    }

    private void findWinner(Cars cars, int max) {
        int i = 0;
        while (i < cars.size()) {
            if (max == cars.findGameNum(i)) {
                i++;
                continue;
            }
            cars.remove(i);
        }
    }

    private void findWinner2(Cars cars, int max) {
        for (int i = 0; i < cars.size(); i++) {
            if (max == cars.findGameNum(i)) {
                winnerRepository.add(cars.findName(i));
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