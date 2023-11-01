package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRaceController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private RaceService raceService = new RaceService();

    public void raceStart() {
        List<String> carsNames = inputView.readCarsNamesInput();
        List<Car> cars = carsNames.stream().map(name -> new Car(name)).collect(Collectors.toList());
        int iteration = inputView.readNumberInput();
        for (int i = 0; i < iteration; i++) {
            raceService.runRace(cars);
            outputView.displayPerResults(cars);
        }
        List<Car> winners = raceService.getWinner(cars);
        outputView.displayResults(winners);
    }
}
