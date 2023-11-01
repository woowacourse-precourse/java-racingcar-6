package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Validator;
import racingcar.util.StringUtils;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame {

    public RacingCarGame() {
    }

    public void play() {

        Cars racingCars = createRacingCars();
        int rounds = getRoundsToInt();
        playByRound(racingCars, rounds);
        showWinners(racingCars);

    }

    public Cars createRacingCars() {
        StringUtils stringUtils = new StringUtils();
        List<String> carNames = stringUtils.separateAndRemoveSpace(InputView.getCarNames());

        Validator validator = new Validator();
        validator.validateCarNames(carNames);

        List<Car> cars = createCars(carNames);
        return new Cars(cars);
    }

    public List<Car> createCars(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public int getRoundsToInt() {
        String rounds = InputView.getRounds();
        Validator validator = new Validator();
        validator.validateRounds(rounds);
        return Integer.valueOf(rounds);
    }

    public void playByRound(Cars cars, int rounds) {
        OutputView.printResultMessage();
        for (int round = 0; round < rounds; round++) {
            cars.moveAllCars();
            showAllCars(cars);
        }
    }

    public void showAllCars(Cars cars) {
        for (Car car : cars.getCars()) {
            OutputView.printStatus(car.getName(), car.getPosition());
        }
        OutputView.printNewLine();
    }

    public void showWinners(Cars cars) {
        List<String> winners = cars.findWinners();
        OutputView.printWinners(winners);
    }

}
