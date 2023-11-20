package racingcar.domain;

import racingcar.util.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static racingcar.domain.CarRule.CAR_LOCATION_INIT;

public class Judge {

    public List<Car> getWinners(List<Car> racingCars) {
        List<Car> winners = new ArrayList<>();
        int maxLocation = findMaxLocation(racingCars);
        for (Car thisCar : racingCars) {
            if (thisCar.getLocation() == maxLocation) {
                winners.add(thisCar);
            }
        }
        return winners;
    }

    private int findMaxLocation(List<Car> racingCars) {
        int maxLocation = CAR_LOCATION_INIT.getNumber();
        NumberGenerator ng = new NumberGenerator();
        for (Car thisCar : racingCars) {
            maxLocation = ng.findMaxNumber(maxLocation, thisCar.getLocation());
        }
        return maxLocation;
    }
}
