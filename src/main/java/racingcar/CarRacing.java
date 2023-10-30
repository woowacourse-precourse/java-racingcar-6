package racingcar;

import java.util.List;
import racingcar.console.RacingCarConsole;
import racingcar.util.Util;

public class CarRacing {
    private final List<Car> carList;
    private final int iterationNumBer;

    public CarRacing(List<Car> carList, int iterationNumBer) {
        this.carList = carList;
        this.iterationNumBer = iterationNumBer;
    }

    public CarRacingResult start() {
        for (int stepNumber = 0; stepNumber < iterationNumBer; stepNumber++) {
            progressOneStep();
            RacingCarConsole.printProgressState(carList);
        }

        CarRacingResult carRacingResult = getCarRacingResult();
        return carRacingResult;
    }

    private CarRacingResult getCarRacingResult() {
        Integer maxLocation = carList.stream()
                .map(Car::getLocation)
                .max(Integer::compare)
                .get();

        List<Car> championCarList = carList.stream()
                .filter(car -> car.getLocation() == maxLocation)
                .toList();

        return new CarRacingResult(championCarList);
    }

    private void progressOneStep() {
        for (Car car : carList) {
            int randomNumber = Util.getRandomDecimalNumber();
            if (isCarMoveForward(randomNumber)) {
                car.moveForward();
            }
        }
    }

    private boolean isCarMoveForward(int randomNumber) {
        return randomNumber >= 4;
    }
}
