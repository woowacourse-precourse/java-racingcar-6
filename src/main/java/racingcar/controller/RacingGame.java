package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    public void start() {
        String input = InputView.carInput();
        List<Car> cars = createCars(input);
        Race race = new Race(cars);
        int tryCount = getTryCount();

        raceMultipleTimes(tryCount, race);

        List<Car> winners = race.getWinners();
        OutputView.printWinners(winners);
    }

    public List<Car> createCars(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public int getTryCount() {
        return Integer.parseInt(InputView.tryCountInput());
    }

    private void raceMultipleTimes(int tryCount, Race race) {
        for (int i = 0; i < tryCount; i++) {
            race.race();
            OutputView.printResult(race);
        }
    }
}
