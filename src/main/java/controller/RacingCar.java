package controller;

import domain.Car;
import domain.Cars;
import domain.RaceResult;
import domain.Winners;
import utils.CarsUtils;
import validator.CarValidator;
import validator.TryCountValidator;
import view.InputView;
import view.OutputView;

public class RacingCar {

    public void startGame() {
        Cars cars = getCars();
        int tryCount = getTryCount();
        startRaceByTryCount(cars, tryCount);
        endRace(cars);
    }

    private Cars getCars() {
        OutputView.printGetCarName();
        String carName = InputView.getCarName();
        String[] carNames = getCarNames(carName);

        Cars cars = new Cars(carNames);
        cars.validateDuplication();

        return cars;
    }

    private int getTryCount() {
        OutputView.printGetTryCount();
        String tryCount = InputView.getTryCount();
        TryCountValidator.validateEmpty(tryCount);
        TryCountValidator.validateTryCountIncludeEmpty(tryCount);
        TryCountValidator.validateString(tryCount);

        int convertIntTryCount = getConvertIntTryCount(tryCount);

        return convertIntTryCount;
    }

    private void startRaceByTryCount(Cars cars, int tryCount) {
        OutputView.printEnter();
        OutputView.printRaceResultIntroduction();
        for (int i = 0; i < tryCount; i++) {
            cars.moveAheadCars();
            moveAheadSituation(cars);
            OutputView.printEnter();
        }
    }

    private void endRace(Cars cars) {
        OutputView.printWinnerIntroduction();
        Winners winners = cars.generateWinners();
        OutputView.printWinner(winners);
    }

    private String[] getCarNames(String beforeCarName) {
        String[] carNames = CarsUtils.splitByCommasDelimiter(beforeCarName);
        for (String carName : carNames) {
            CarValidator.validateNameIncludeEmpty(carName);
            CarValidator.validateNameLength(carName);
        }

        return carNames;
    }

    private int getConvertIntTryCount(String tryCount) {
        int convertIntTryCount = Integer.parseInt(tryCount);
        TryCountValidator.validateNatureNumber(convertIntTryCount);

        return convertIntTryCount;
    }

    private void moveAheadSituation(Cars cars) {
        for (Car car : cars.getCars()) {
            RaceResult raceResult = car.generateResult();
            OutputView.printRaceResult(raceResult);
        }
    }
}
