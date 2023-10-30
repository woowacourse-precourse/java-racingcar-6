package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Cars;
import racingcar.repository.GameRepository;

public class GameService {
    private final PrintService print = new PrintService();
    private final GameRepository gameRepository = new GameRepository();

    public void run(int gameNum) {
        print.result();
        Cars cars = gameRepository.findCars();

        while (gameNum > 0) {
            addRandomNum(cars);
            print.racing(cars.size(), cars);
            gameNum--;
        }

        findWinner(cars, cars.findMaxAdvanceNum());
        print.winner(cars);
    }

    private void findWinner(Cars cars, int max) {
        int i = 0;
        while (i < cars.size()) {
            if (max != cars.findGameNum(i)) {
                cars.remove(i);
                continue;
            }
            i++;
        }
    }

    private void addRandomNum(Cars cars) {
        for (int i = 0; i < cars.size(); i++) {
            int random = Randoms.pickNumberInRange(0, 9);
            if (random < 4) {
                continue;
            }
            cars.plusNum(i);
        }
    }
}