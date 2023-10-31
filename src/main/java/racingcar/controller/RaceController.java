package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Count;
import racingcar.domain.NumberGenerator;
import racingcar.domain.Race;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RaceService raceService;

    public RaceController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.raceService = new RaceService();
    }

    public void run() {
        Race race = initializeRace();
        runRace(race);
        findWinners(race);
    }

    private void findWinners(Race race) {
        List<String> winners = raceService.findWinners(race);
        outputView.winnersOutput(winners);
    }

    private Race initializeRace() {
        Cars cars = initializeCars();
        Count count = initializeCount();
        NumberGenerator numberGenerator = new NumberGenerator();
        return new Race(cars, count, numberGenerator);
    }

    private Count initializeCount() {
        outputView.countOutput();
        String countInput = inputView.getCountInput();
        return new Count(countInput);
    }

    private Cars initializeCars() {
        outputView.carNamesOutput();
        List<String> carNamesInput = inputView.getCarNamesInput();
        return new Cars(carNamesInput);
    }

    private void runRace(Race race) {
        while (race.playable()) {
            List<Car> raceCars = raceService.runRace(race);
            outputView.carsDistanceOutput(raceCars);
        }
    }
}
