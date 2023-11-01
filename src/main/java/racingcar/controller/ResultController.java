package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.RacingCars;

public class ResultController {
    private final RacingCars racingCars;

    public ResultController(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public void showWinners() {
        List<Car> winners = racingCars.findWinners();
        String winnerNames = winners.stream()
            .map(Car::getName)
            .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
