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

    private Input input = new Input();
    private Output output = new Output();
    private Validator validator = new Validator();

    public void play() {
        String[] carNames = validator.stringToArray(input.getCarNames());
        List<Car> cars = createCars(carNames);
        int attemptCount = validator.stringToInt(input.getNumberOfAttempts());

        proceedRacing(attemptCount, cars);
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
        cars.forEach(car -> {
            if (isCarMove()) car.addLocation();
        });
    }

    private boolean isCarMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
