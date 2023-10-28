package racingcar.game;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarFactory;
import racingcar.domain.Cars;
import racingcar.strategy.MoveStrategy;
import racingcar.strategy.RandomMoveStrategy;
import racingcar.view.Input;
import racingcar.view.Output;

public class RacingGame {
    private final MoveStrategy moveStrategy = new RandomMoveStrategy();

    public void play() {
        List<String> carNames = Input.getCarNames();
        int totalRace = Input.getTotalRace();

        Cars initalCars = CarFactory.createCars(carNames);
        Race race = Race.of(initalCars, totalRace, moveStrategy);

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
