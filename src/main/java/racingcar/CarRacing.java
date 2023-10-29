package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class CarRacing {
    private final List<Car> carList;
    private final int iterationNumBer;

    public CarRacing(List<Car> carList, int iterationNumBer) {
        this.carList = carList;
        this.iterationNumBer = iterationNumBer;
    }

    public CarRacingResult start() {
        System.out.println();
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
            if (isCarMoveForward()) {
                car.moveForward();
            }
        }
    }

    private boolean isCarMoveForward() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }
}
