package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.service.CarFactoryService;
import racingcar.service.RaceService;
import racingcar.service.ValidationService;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RaceController {

    private final RaceService raceService;
    private final ValidationService validationService;

    public RaceController() {
        this.raceService = new RaceService();
        this.validationService = new ValidationService();
    }

    public void startGame() {
        Race race = getRaceInput();
        playRace(race);
        endRace(race);
    }
    
    private Race getRaceInput() {
        List<String> carNames = validationService.validateCarsRange(InputView.getCarNames());
        int rounds = validationService.validateRoundType(InputView.getRounds());
        validationService.validateCarsName(carNames);
        validationService.validateRoundRange(rounds);
        List<Car> cars = CarFactoryService.createCars(carNames);
        return new Race(cars, rounds);
    }

    private void playRace(Race race) {
        raceService.executeRace(race);
        ResultView.printRoundResult(race.getCars());
    }

    private void endRace(Race race) {
        List<Car> winners = raceService.findWinners(race);
        ResultView.printWinners(winners);
        Console.close();
    }

}
