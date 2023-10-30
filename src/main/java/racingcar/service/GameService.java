package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Cars;
import racingcar.repository.GameRepository;

public class GameService {
    private final MessageService message = new MessageService();
    private final GameRepository gameRepository = new GameRepository();
    private List<String> result = new ArrayList<>();

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

            for (int i = 0; i < cars.size(); i++) {
                message.printProcess(cars.findName(i));

                for (int j = 0; j < cars.findGameNum(i); j++) {
                    System.out.print("-");
                }
                message.jump();
            }
            message.jump();

            gameNum--;
        }

        int max = cars.findMaxAdvanceNum();
        for (int i = 0; i < cars.size(); i++) {
            if (max == cars.findGameNum(i)) {
                result.add(cars.findName(i));
            }
        }
        String[] array = result.toArray(String[]::new);
        String join = String.join(", ", array);
        message.printWinner(join);
    }
}