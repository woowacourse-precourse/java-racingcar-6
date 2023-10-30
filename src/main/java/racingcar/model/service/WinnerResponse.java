package racingcar.model.service;

import java.util.ArrayList;
import java.util.List;

import racingcar.model.Car;

public record WinnerResponse(List<Car> winnerCars) {
    public WinnerResponse(final List<Car> winnerCars){
        this.winnerCars = winnerCars;
    }

    public static WinnerResponse from(final List<Car> cars, final int maxDistance) {
        List<Car> winnerCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getDistance() == maxDistance) {
                winnerCars.add(car);
            }
        }

        return new WinnerResponse(winnerCars);
    }
}
