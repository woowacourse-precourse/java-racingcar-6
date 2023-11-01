package racingcar.controller;

import java.util.LinkedHashSet;
import java.util.List;
import racingcar.domain.Car;
import racingcar.dto.CarDto;
import racingcar.mapper.CarDtoMapper;
import racingcar.observer.Observer;
import racingcar.service.RacingInitService;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController implements Observer {
    private final RacingService racingService = new RacingService();
    private final RacingInitService racingInitService = new RacingInitService();
    private List<String> carNames;
    private int attemptCount;
    private LinkedHashSet<Car> cars;

    public void run() {
        readyRace();
        startRace();
    }

    private void readyRace() {
        OutputView.printCarNameInputMessage();
        carNames = racingService.carValidate(getUserInput());

        OutputView.printAttemptCountInputMessage();
        attemptCount = Integer.parseInt(racingInitService.attemptCountValidate(getUserInput()));

        createCars();
        addObserverToCar(cars);
    }

    private void startRace() {
        OutputView.printGameResultMessage();

        racingService.moveAllCar(attemptCount, cars, OutputView::printEachRoundSeparator);
        LinkedHashSet<CarDto> carDtos = racingInitService.createCarDtos(cars);
        List<String> winners = racingService.generateRaceResult(carDtos);

        OutputView.printWinner(winners);
    }

    private String getUserInput() {
        return InputView.getUserInput();
    }

    private void createCars() {
        cars = racingInitService.createCars(carNames);
    }

    void addObserverToCar(LinkedHashSet<Car> cars) {
        for (Car car : cars) {
            car.addObserver(this);
        }
    }

    @Override
    public void display(Car car) {
        CarDto carDto = CarDtoMapper.from(car);
        OutputView.printRoundResult(carDto.name(), carDto.moved());
    }
}