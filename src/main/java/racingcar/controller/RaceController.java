package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.repository.CarRepository;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private final RaceService raceService = new RaceService();
    private final CarRepository carRepository = new CarRepository();

    public void run() {
        Race race = raceService.createRace(getCarListByCarNames(getCarNamesByInput()), getNumRacesByInput());
        raceService.saveRace(race);
        play(race);
        getFinalResult(race);
    }


    private void play(Race race) {
        OutputView.printIndividualResultHeader();
        while (!race.checkGamesExhausted()) {
            raceService.playARace(race);
            OutputView.printIndividualResult(race);
        }
    }

    private void getFinalResult(Race race) {
        OutputView.printFinalResult(raceService.getWinners(race));
    }


    private List<Car> getCarListByCarNames(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .peek(carRepository::save)
                .collect(Collectors.toList());
    }

    private List<String> getCarNamesByInput() {
        InputView.printRequestForCarNames();
        String carNamesInput = Console.readLine();
        return raceService.processCarNames(carNamesInput);
    }

    private int getNumRacesByInput() {
        InputView.printRequestForNumRaces();
        String numRacesInput = Console.readLine();
        return raceService.processNumRaces(numRacesInput);
    }
}
