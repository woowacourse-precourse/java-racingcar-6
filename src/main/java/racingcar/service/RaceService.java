package racingcar.service;

import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.view.InputRaceView;
import racingcar.view.OutputRaceView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RaceService {
    private Race race;

    public void start() {
        List<Car> cars = Arrays.stream(InputRaceView.readCarNames().split(","))
                .map(Car::new)
                .collect(Collectors.toList());

        int raceCount = InputRaceView.readRaceCount();
        race = new Race(cars);

        for (int i = 0; i < raceCount; i++) {
            race.run();
            OutputRaceView.printRaceResult(race.getCars());
        }
    }
}
