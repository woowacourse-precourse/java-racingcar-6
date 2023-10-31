package racingcar;

import java.util.List;
import racingcar.console.RacingCarConsole;
import racingcar.policy.Policy;

public class CarRacing {
    private final List<Car> carList;
    private final int iterationNumBer;
    private final Policy policy;

    public CarRacing(List<Car> carList, int iterationNumBer, Policy policy) {
        this.carList = carList;
        this.iterationNumBer = iterationNumBer;
        this.policy = policy;
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
            int randomNumber = policy.getRandomDecimalNumber();
            if (policy.isCarMoveForward(randomNumber)) {
                car.moveForward();
            }
        }
    }
}
