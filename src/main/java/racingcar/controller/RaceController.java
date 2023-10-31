package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.domain.User;

public class RaceController {

    private final User user;

    public RaceController(User user) {
        this.user = user;
    }

    public void run() {
        List<String> carNames = user.getCarNames();
        int raceCount = user.getRaceCount();

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        Race race = new Race(cars, raceCount);

        race.printRaceResult();
    }

}
