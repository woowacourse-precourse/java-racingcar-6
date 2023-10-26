package racingcar.service;

import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.util.OutputRaceViewConstant;
import racingcar.view.InputRaceView;
import racingcar.view.OutputRaceView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RaceService {
    private Race race;

    public void start() {
        List<Car> cars = initializeCars();
        int raceCount = getRaceCount();
        race = new Race(cars);

        System.out.println(OutputRaceViewConstant.RACE_RESULT_HEADER);
        conductRaces(raceCount);
    }

    private List<Car> initializeCars() {
        return Arrays.stream(InputRaceView.readCarNames().split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private int getRaceCount() {
        return InputRaceView.readRaceCount();
    }

    private void conductRaces(int raceCount) {
        for (int i = 0; i < raceCount; i++) {
            race.run();
            OutputRaceView.printRaceResult(race.getCars());
        }
    }

    public List<Car> getWinners() {
        int maxPosition = race.getCars().stream().mapToInt(Car::getDistance).max().orElse(0);
        return race.getCars().stream().filter(car -> car.getDistance() == maxPosition).collect(Collectors.toList());
    }
}
