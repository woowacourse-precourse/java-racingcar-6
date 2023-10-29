package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarRepository;

public class GameService {
    private final MessageService message = new MessageService();
    private CarRepository carRepository = new CarRepository();
    private List<String> result = new ArrayList<>();

    public void run(int gameNum) {
        message.printResult();
        List<Car> carsList = carRepository.find();
        while (gameNum > 0) {
            for (int i = 0; i < carRepository.size(); i++) {
                int random = Randoms.pickNumberInRange(0, 9);
                if (random < 4) {
                    continue;
                }
                carsList.get(i).plus();
            }

            for (int i = 0; i < carRepository.size(); i++) {
                message.printProcess(carsList.get(i).findName());

                for (int j = 0; j < carsList.get(i).findAdvanceNum(); j++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
            gameNum--;
        }
        int max = carRepository.findMaxAdvanceNum();

        for (int i = 0; i < carRepository.size(); i++) {
            if (max == carsList.get(i).findAdvanceNum()) {
                result.add(carsList.get(i).findName());
            }
        }
        String[] array = result.toArray(String[]::new);
        String join = String.join(", ", array);
        message.printWinner(join);
    }
}