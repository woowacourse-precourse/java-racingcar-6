package racingcar.controller;

import java.util.LinkedHashSet;
import java.util.List;
import racingcar.domain.Car;
import racingcar.observer.Observer;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController implements Observer {
    private final RacingService racingService = new RacingService();
    private List<String> carNames;
    private int attemptCount;
    private LinkedHashSet<Car> cars;

    public void run() {
        setRacing();
        createCars();
        addObserverToCar(cars);
        startRace();
    }

    private void setRacing() {
        OutputView.printCarNameInputMessage();
        carNames = racingService.carValidate(getUserInput());
        OutputView.printAttemptCountInputMessage();
        attemptCount = racingService.attemptCountValidate(Integer.parseInt(getUserInput()));
    }

    private void createCars() {
        cars = racingService.createCars(carNames);
    }

    private void startRace() {
        OutputView.printGameResultMessage();
        racingService.moveAllCar(attemptCount, cars);

        List<String> winners =  racingService.generateRaceResult(cars);
        OutputView.printWinner(winners);
    }

    private String getUserInput() {
        return InputView.getUserInput();
    }

    void addObserverToCar(LinkedHashSet<Car> cars) {
        for(Car car : cars) {
            car.addObserver(this);
        }
    }
    @Override
    public void display(Car car) {
        OutputView.printRealTimeResult(car.getName(), car.getMoved());
    }
}
