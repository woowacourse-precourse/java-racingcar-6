package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.util.RandomGenerator;
import racingcar.domain.Validator;
import racingcar.util.StringUtils;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame {

    private final List<Car> cars;
    private final int MIN_RANGE_NUM = 0;
    private final int MAX_RANGE_NUM = 9;

    public RacingCarGame() {
        cars = new ArrayList<>();
    }

    public void play() {
        StringUtils stringUtils = new StringUtils();
        Validator validator = new Validator();

        List<String> carNames = stringUtils.separateAndRemoveSpace(InputView.getCarNames());
        validator.validateCarNames(carNames);
        String rounds = InputView.getRounds();
        validator.validateRounds(rounds);

        createCar(carNames);
        playByRound(Integer.valueOf(rounds));
    }

    public void createCar(List<String> names) {
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public void playByRound(int rounds) {
        OutputView.printResultMessage();
        for (int round = 0; round < rounds; round++) {
            moveAllCars();
            showAllCars();
        }
    }

    public void moveAllCars() {
        RandomGenerator randomGenerator = new RandomGenerator();
        for (Car car : cars) {
            int randomNumber = randomGenerator.createRandomNumber(MIN_RANGE_NUM, MAX_RANGE_NUM);
            car.move(randomNumber);
        }
    }

    public void showAllCars() {
        for (Car car : cars) {
            OutputView.printStatus(car.getName(), car.getPosition());
        }
        OutputView.printNewLine();
    }

}
