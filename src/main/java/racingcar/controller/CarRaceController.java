package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarRace;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRaceController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public void raceStart() {
        List<String> carsNames = inputView.readCarsNamesInput();
        List<Car> cars = carsNames.stream().map(name -> new Car(name)).toList();

        int iteration = inputView.readNumberInput();
        CarRace carRace = new CarRace(cars, iteration);

        outputView.displayStart();
        for (int i = 0; i < carRace.getIteration(); i++) {
            carRace.runRace();
            outputView.displayPerRace(cars);
        }

        List<Car> winners = carRace.getWinner();
        outputView.displayResults(winners);
    }
}
