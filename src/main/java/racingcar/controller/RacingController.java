package racingcar.controller;

import racingcar.utils.InputValidator;
import racingcar.utils.RandomNumberGenerater;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingController {
    private final Cars cars;
    private Race race;
    private final RandomNumberGenerater randomNumberGenerater;
    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidator validator;

    public RacingController(Cars cars, Race race, RandomNumberGenerater randomNumberGenerater, InputView inputView, OutputView outputView, InputValidator validator) {
        this.cars = cars;
        this.race = race;
        this.randomNumberGenerater = randomNumberGenerater;
        this.inputView = inputView;
        this.outputView = outputView;
        this.validator = validator;
    }

    public void start() {
        cars.generateCars(inputCars());
        int times = inputTimes();
        race = new Race(cars, times);
        while (race.run()) {
            printCurrentStatus();
        }
        List<String> winnerList = race.findWinner();
        String winners = winnerList.stream()
                        .collect(Collectors.joining(", "));
        outputView.printWinner(winners);
    }

    public void printCurrentStatus() {
        List<Car> carList = cars.getCars();
        StringBuilder process = new StringBuilder();
        carList.forEach(car -> process.append(car.info()));
        outputView.printProcess(process.toString());
    }

    public String inputCars() {
        outputView.printInputCars();
        String carsInput = inputView.inputCars();
        validator.validateCars(carsInput);
        return carsInput;
    }

    public int inputTimes() {
        outputView.printInputTimes();
        String timesInput = inputView.inputTimes();
        validator.validateTimes(timesInput);
        return Integer.parseInt(timesInput);
    }
}
