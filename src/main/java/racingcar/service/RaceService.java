package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.dto.CarCondition;
import racingcar.dto.RaceResult;

public class RaceService {
    private static RaceService raceService;
    private static Race race;

    public void initRace(String carNames) {
        race = new Race(carNames);
    }

    public CarCondition proceed() {
        for (Car car : race.getCars()) {
            car.move();
        }
        return createCarCondition();
    }

    private CarCondition createCarCondition() {
        List<String> names = new ArrayList<>();
        List<Integer> positions = new ArrayList<>();
        for (Car car : race.getCars()) {
            names.add(car.getName());
            positions.add(car.getPosition());
        }
        return new CarCondition(names, positions);
    }

    public RaceResult end() {
        return null;
    }

    public static RaceService getInstance() {
        if (raceService == null) {
            raceService = new RaceService();
        }
        return raceService;
    }

    private RaceService() {}
}
