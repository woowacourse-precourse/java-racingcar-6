package racingcar.controller;

import racingcar.model.CarModel;
import racingcar.util.CarNamesToArray;
import racingcar.util.RandomNumber;
import racingcar.util.Verifier;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.OptionalInt;

public class Race {
    CarModel[] cars;

    /**
     * 레이스 시
     */
    public void start() {
        String[] carNames = getCarNames();
        int tryCount = getTryCount();
        cars = createCars(carNames);

        OutputView.printResult();

        raceTry(tryCount);

        OutputView.printWinners(getWinners());
    }

    private String[] getCarNames() {
        String carNamesString = InputView.getCarNames();
        Verifier.verifyCarNamesString(carNamesString);

        String[] carNames = CarNamesToArray.convert(carNamesString);
        Verifier.verifyCarNameDuplication(carNames);

        Arrays.stream(carNames).forEach(Verifier::verifyCarName);

        return carNames;
    }

    private int getTryCount() {
        String tryCount = InputView.getTryCount();
        Verifier.verifyTrialNumber(tryCount);

        return Integer.parseInt(tryCount);
    }

    private CarModel[] createCars(String[] carNames) {
        CarModel[] cars;

        cars = new CarModel[carNames.length];

        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new CarModel(carNames[i]);
        }

        return cars;
    }

    private void raceTry(Integer tryCount) {
        for (int i = 0; i < tryCount; i++) {
            randomMoveAllCars();
            OutputView.printGameResult(cars);
        }
    }

    private void randomMoveAllCars() {
        for (CarModel car : cars) {
            randomMove(car);
        }
    }

    private void randomMove(CarModel car) {
        if (RandomNumber.generate() >= 4) {
            car.move();
        }
    }

    private String[] getWinners() {
        int maxPosition = getMaxPosition();

        return Arrays.stream(cars)
                .filter(car -> car.getPosition() == maxPosition)
                .map(CarModel::getName)
                .toArray(String[]::new);
    }

    private Integer getMaxPosition() {
        OptionalInt optMaxPosition = Arrays.stream(cars)
                .mapToInt(CarModel::getPosition)
                .max();

        return optMaxPosition.orElse(0);
    }
}
