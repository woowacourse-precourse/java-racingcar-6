package controller;

import static message.OutputMessages.RACE_START;
import static validator.CarNameValidator.validateCarNameDuplicate;
import static validator.CarNameValidator.validateCarNameLength;
import static validator.TryCountValidator.validateTryCountMin;
import static validator.TryCountValidator.validateTryCountNumber;

import java.util.ArrayList;
import java.util.List;
import model.Car;
import view.InputView;
import view.OutputView;

public class RacingGameController {


    public void play() {
        String[] carNames = InputView.getCarNames();
        validateCarNames(carNames);
        List<Car> carList = createCars(carNames);

        String tryCount = InputView.getTryCount();
        validateTryCount(tryCount);
        int tryCountNumber = Integer.parseInt(tryCount);

        startRace(carList, tryCountNumber);

        OutputView.printWinners(carList);

    }

    private void startRace(List<Car> carList, int tryCountNumber) {
        System.out.println(RACE_START);

        while (tryCountNumber > 0) {
            for (Car car : carList) {
                car.move();
                OutputView.printRacingResult(car);
            }
            System.out.println();
            tryCountNumber--;
        }
    }

    private List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }


    public void validateCarNames(String[] carNameList) {
        validateCarNameLength(carNameList);
        validateCarNameDuplicate(carNameList);
    }

    public void validateTryCount(String tryCount) {
        validateTryCountNumber(tryCount);
        validateTryCountMin(tryCount);
    }

}
