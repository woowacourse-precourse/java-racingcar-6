package racingcar.controller;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.dto.RaceStatus;
import racingcar.view.InputConsoleView;
import racingcar.view.OutputConsoleView;

public class CarRacingGame {

    private final InputConsoleView inputConsoleView;
    private final OutputConsoleView outputConsoleView;
    private final Cars cars;
    private int numberOfTrial;

    public CarRacingGame() {
        inputConsoleView = new InputConsoleView();
        outputConsoleView = new OutputConsoleView();
        cars = new Cars();
    }

    public void run() {

        initialParticipant(getCarName());
        initialNumberOfTrial(getNumberOfTrial());

        startRace(numberOfTrial);
    }

    private String getCarName() {
        outputConsoleView.printAskingCarName();
        return inputConsoleView.readCarName();
    }

    private String getNumberOfTrial() {
        outputConsoleView.printAskingNumberOfTrial();
        return inputConsoleView.readNumberOfTrial();
    }

    private void initialParticipant(String carNames) {
        cars.addCars(carNames.split(","));
    }

    private void initialNumberOfTrial(String number) {
        numberOfTrial = Integer.parseInt(number);
    }

    private void startRace(int numberOfTrial) {

        outputConsoleView.printRaceResult();
        while (numberOfTrial > 0) {
            cars.moveCars();
            printRaceStatus(cars.getCars());
            numberOfTrial--;
        }

    }

    private void printRaceStatus(List<Car> cars) {
        outputConsoleView.printRaceStatus(getRaceStatuses(cars));
    }

    private List<RaceStatus> getRaceStatuses(List<Car> cars) {
        return cars.stream()
                .map(car -> new RaceStatus(car.getName(),car.getDistance()))
                .toList();
    }


}
