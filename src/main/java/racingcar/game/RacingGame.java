package racingcar.game;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Name;
import racingcar.view.Input;
import racingcar.view.Output;

public class RacingGame {
    public void play() {
        List<String> carNames = Input.getCarNames();
        int totalRace = Input.getTotalRace();

        Cars cars = createCars(carNames);
        Race race = Race.of(cars, totalRace);

        while (race.hasRemainingRaces()) {
            race.performRaceStep();
//            race.getRaceStatus();
        }

        List<Car> car = race.determineWinners();
        Output.printWinnersName(car);
    }

    private Cars createCars(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Name::from)
                .map(Car::from)
                .toList();

        return Cars.from(cars);
    }
}
