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
        for (int i = 0; i < iteration; i++) {
            carRace.runRace(cars);
            outputView.displayPerRace(cars);
        }

        List<Car> winners = carRace.getWinner(cars);
        outputView.displayResults(winners);
    }
}
