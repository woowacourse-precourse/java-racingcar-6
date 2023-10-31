package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameService {

    private static final int MAX_PICK_NUMBER = 9;
    private static final int MIN_PICK_NUMBER = 0;
    private static final int REFERENCE_PICK_NUMBER = 4;
    private Input input = new Input();
    private Output output = new Output();
    private Validator validator = new Validator();

    public void play() {
        String[] carNames = validator.stringToArray(input.getCarNames());
        List<Car> cars = createCars(carNames);
        int attemptCount = validator.stringToInt(input.getNumberOfAttempts());

        proceedRacing(attemptCount, cars);
        output.printGameWinner(getWinner(cars));
    }

    private List<String> getWinner(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        int maxLocationLength = 0;
        for (Car car : cars) {
            maxLocationLength = getMaxLocationLength(car, maxLocationLength, winners);
        }
        return winners;
    }

    private static int getMaxLocationLength(Car car, int maxLocationLength, List<String> winners) {
        int currentLength = car.getLocation().length();
        if (currentLength > maxLocationLength) {
            maxLocationLength = currentLength;
            winners.clear();
            winners.add(car.getName());
        } else if (currentLength == maxLocationLength) {
            winners.add(car.getName());
        }
        return maxLocationLength;
    }

    private void proceedRacing(int attemptCount, List<Car> cars) {
        output.printResultMessage();
        for (int i = 0; i < attemptCount; i++) {
            carMove(cars);
            output.printResultsByOrder(cars);
        }
    }

    private List<Car> createCars(String[] carNames) {
        return Arrays.stream(carNames).map(Car::new).collect(Collectors.toList());
    }

    private void carMove(List<Car> cars) {
        for (Car car : cars) {
            if (isCarMove()) {
                car.addLocation();
            }
        }
    }

    private boolean isCarMove() {
        return Randoms.pickNumberInRange(MIN_PICK_NUMBER, MAX_PICK_NUMBER) >= REFERENCE_PICK_NUMBER;
    }
}
