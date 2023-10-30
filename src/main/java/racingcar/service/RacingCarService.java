package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import racingcar.domain.Car;
import racingcar.utils.InputValidator;
import racingcar.utils.Message;
import racingcar.view.OutputView;

public class RacingCarService {
    private static final int RANDOM_MIN_NUMBER = 0;
    private static final int RANDOM_MAX_NUMBER = 9;
    private static final int MOVE_CONDITION = 4;
    private static final List<Car> carList = new ArrayList<>();

    public List<Car> participateCar(List<String> carsName) {
        for (String name : carsName) {
            InputValidator.validateEmptyInput(name);
            InputValidator.validateInputLength(name);
            InputValidator.validateDuplicateInput(carList, name);
            carList.add(new Car(name));
        }
        return carList;
    }

    public static void moveCar() {
        List<Integer> randomNumbers = generateRandomNumbers();
        for (int i = 0; i < carList.size(); i++) {
            if (randomNumbers.get(i) >= MOVE_CONDITION) {
                carList.get(i).move();
            }
            OutputView.printRaceRoundResults(carList.get(i).getName(), carList.get(i).getMoveCount());
        }
    }

    private static List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < carList.size(); i++) {
            randomNumbers.add(Randoms.pickNumberInRange(RANDOM_MIN_NUMBER, RANDOM_MAX_NUMBER));
        }
        return randomNumbers;
    }

    public String findWinners() {
        carList.sort(Comparator.comparingInt(Car::getMoveCount).reversed());
        int maxMoveCount = carList.get(0).getMoveCount();

        List<String> maxMoveCountCarNames = new ArrayList<>();

        for (Car car : carList) {
            if (carList.get(0).getMoveCount() != maxMoveCount) {
                break;
            }
            if (car.getMoveCount() == maxMoveCount) {
                maxMoveCountCarNames.add(car.getName());
            }
        }
        return classifyWinners(maxMoveCountCarNames);
    }

    private String classifyWinners(List<String> winners) {
        return Message.FINAL_WINNER_MESSAGE.getMessage() + String.join(", ", winners);
    }
}
