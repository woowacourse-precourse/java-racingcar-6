package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Cars;
import racingcar.repository.GameRepository;

public class GameService {
    private final MessageService message = new MessageService();
    private final GameRepository gameRepository = new GameRepository();

    public void run(int gameNum) {
        message.printResult();
        Cars cars = gameRepository.findCars();

        while (gameNum > 0) {
            for (int i = 0; i < cars.size(); i++) {
                int random = Randoms.pickNumberInRange(0, 9);
                if (random < 4) {
                    continue;
                }
                cars.plusGameNum(i);
            }

            message.printRacing(cars.size(), cars);
            gameNum--;
        }

        int max = cars.findMaxAdvanceNum();
        int i = 0;
        while (i < cars.size()) {
            if (max != cars.findGameNum(i)) {
                cars.remove(i);
                continue;
            }
            i++;
        }

        System.out.print("최종 우승자 : ");
        for (int j = 0; j < cars.size(); j++) {
            if (j == cars.size() - 1) {
                System.out.print(cars.findName(j));
                continue;
            }
            System.out.print(cars.findName(j) + ", ");
        }
    }
}