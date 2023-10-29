package controller;

import java.util.ArrayList;
import java.util.List;
import message.OutputMessages;
import model.Car;
import validator.CarNameValidator;
import validator.TryCountValidator;
import view.InputView;
import view.OutputView;

public class RacingGameController {

    private final InputView inputView = new InputView();
    private final CarNameValidator carNameValidator = new CarNameValidator();
    private final TryCountValidator tryCountValidator = new TryCountValidator();

    public void play() {
        List<String> carNameList = inputView.getCarNames();
        validateCarNames(carNameList);
        List<Car> carList = createCars(carNameList);

        String tryCount = inputView.getTryCount();
        validateTryCount(tryCount);
        int tryCountNumber = Integer.parseInt(tryCount);

        startRace(carList, tryCountNumber);

        OutputView.printWinners(carList);

    }

    private void startRace(List<Car> carList, int tryCountNumber) {
        System.out.println(OutputMessages.RACE_START);

        while (tryCountNumber > 0) {
            for (Car car : carList) {
                car.move();
                OutputView.printRacingResult(car);
            }
            System.out.println();
            tryCountNumber--;
        }
    }

    private List<Car> createCars(List<String> carNameList) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNameList) {
            cars.add(new Car(carName));
        }
        return cars;
    }


    public void validateCarNames(List<String> carNameList) {
        carNameValidator.validateCarNameLength(carNameList);
        carNameValidator.validateCarNameDuplicate(carNameList);
    }

    public void validateTryCount(String tryCount) {
        tryCountValidator.validateTryCountNumber(tryCount);
        tryCountValidator.validateTryCountMin(tryCount);
    }

}
