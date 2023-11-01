package racingcar.controller;

import racingcar.domain.car.Cars;
import racingcar.domain.car.Name;
import racingcar.domain.race.Count;
import racingcar.domain.race.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;

    private Race race;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void init() {
        final List<Name> carNames = getCarNamesFromInput();
        final Cars cars = createCars(carNames);
        final Count raceCount = getRaceCountFromInput();
        race = new Race(cars, raceCount);
    }

    public void start() {
        while (!race.isOver()) {
            race.runOneCycle();
        }
        outputView.printRacingResult(race.toString());
    }

    public void end() {
        outputView.printWinnerResult(race.toWinnerResultString());
    }

    private List<Name> getCarNamesFromInput() {
        return inputView.inputCarNames().stream().map(Name::new).toList();
    }

    private Cars createCars(List<Name> carNames) {
        return new Cars(carNames);
    }

    private Count getRaceCountFromInput() {
        return new Count(inputView.inputRaceCount());
    }
}
