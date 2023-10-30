package racingcar.controller;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.car.DecideRule;
import racingcar.domain.car.Decider;
import racingcar.domain.car.Generator;
import racingcar.domain.car.Name;
import racingcar.domain.car.RandomNumberGenerator;
import racingcar.domain.car.Rule;
import racingcar.service.Attempt;
import racingcar.service.Service;
import racingcar.service.ServiceFactory;
import view.inputView.InputView;
import view.outputView.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private Service gameService;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void execute() {
        setUp();
        play();
        end();
    }

    private void setUp() {
        Cars cars = getCars();
        Attempt attempt = readAttempt();
        gameService = ServiceFactory.offer(cars, attempt);
    }

    private void play() {
        outputView.printResultMessage();
        while (!gameService.isOver()) {
            gameService.moveCars();
            gameService.tryToOff();
            outputView.printResults(gameService.getResults());
        }
    }

    private void end() {
        outputView.printWinners(gameService.getWinnerNames());
    }

    private Cars getCars() {
        List<Car> carList = readNamesAndMakeCarList();
        Decider decider = generateDecider();
        return Cars.of(carList, decider);
    }

    private List<Car> readNamesAndMakeCarList() {
        outputView.printInsertCarNamesMessage();
        List<String> names = inputView.readCarNames();
        return names.stream()
                .map(Name::new)
                .map(Car::withName)
                .toList();
    }

    private static Decider generateDecider() {
        Rule rule = new DecideRule();
        Generator generator = new RandomNumberGenerator();
        return Decider.of(rule, generator);
    }

    private Attempt readAttempt() {
        outputView.printInsertAttemptMessage();
        int attemptValue = inputView.readAttempt();
        return Attempt.withNumber(attemptValue);
    }
}
