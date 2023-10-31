package racingcar.game;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarFactory;
import racingcar.domain.Cars;
import racingcar.strategy.RandomMoveStrategy;
import racingcar.view.Input;
import racingcar.view.Output;

public class RacingGame {
    public void play() {
        List<String> carNames = Input.getCarNames();
        int totalRace = Input.getTotalRace();

        Cars initalCars = CarFactory.createCarsFromNamesWithStrategy(carNames, RandomMoveStrategy.getInstance());
        Race race = Race.of(initalCars, totalRace);

        Output.printResultMessage();

        while (race.hasRemainingRaces()) {
            race.performRaceStep();

            Cars cars = race.getCars();
            Output.printCarStatus(cars);
        }

        List<Car> car = race.determineWinners();
        Output.printWinnersName(car);
    }
}
