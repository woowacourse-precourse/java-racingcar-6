package racingcar.controller;

import static racingcar.view.InputView.readCarsNamesInput;
import static racingcar.view.InputView.readNumberInput;
import static racingcar.view.OutputView.displayPerRace;
import static racingcar.view.OutputView.displayResults;
import static racingcar.view.OutputView.displayStartRace;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarRace;

public class CarRaceController {

    public void raceStart() {
        List<String> carsNames = readCarsNamesInput();
        List<Car> cars = carsNames.stream().map(name -> new Car(name)).toList();

        int iteration = readNumberInput();
        CarRace carRace = new CarRace(cars, iteration);

        displayStartRace();
        for (int i = 0; i < carRace.getIteration(); i++) {
            carRace.runRace();
            displayPerRace(cars);
        }

        displayResults(carRace.getWinner());
    }
}
