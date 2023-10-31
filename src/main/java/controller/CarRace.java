package controller;

import static enums.PrintMessages.*;

import domain.Car;
import domain.CarRaceResultEvaluator;
import domain.Cars;
import domain.ForwardStrategy;
import domain.RandomForwardStrategy;
import dto.RoundResultDto;
import dto.WinnerDto;
import java.util.List;
import util.convertor.StringListToCarListConvertor;
import util.convertor.StringToIntConvertor;
import util.convertor.StringToStringListConvertor;
import util.formatter.RoundResultFormatter;
import util.formatter.WinnerFormatter;
import view.ConsoleInput;
import view.ConsoleOutput;
import view.Input;
import view.Output;

public class CarRace implements Race {

    private static final int MINIMUM_PLAY_COUNT = 0;
    private final Input input;
    private final Output output;

    private final ForwardStrategy forwardStrategy;

    private final CarRaceResultEvaluator carRaceResultEvaluator;

    public CarRace(Input input, Output output, ForwardStrategy forwardStrategy,
            CarRaceResultEvaluator carRaceResultEvaluator) {
        this.input = input;
        this.output = output;
        this.forwardStrategy = forwardStrategy;
        this.carRaceResultEvaluator = carRaceResultEvaluator;
    }

    @Override
    public void executeRace() {
        output.print(CAR_NAME_PROMPT.getMessage());
        Cars cars = createCarsFromUserInput();
        output.print(TRY_COUNT_PROMPT.getMessage());
        int playCount = StringToIntConvertor.convert(input.input());
        runRaceRounds(cars, playCount);
        displayRaceWinners(cars);
    }

    private void runRaceRounds(Cars cars, int playCount) {
        while (isPlayable(playCount)) {
            playRound(cars);
            playCount--;
            displayRoundResults(cars);
        }
    }

    private boolean isPlayable(int playCount) {
        return playCount > MINIMUM_PLAY_COUNT;
    }

    private void playRound(Cars cars) {
        for (Car car : cars.getAllCars()) {
            tryMoveCar(car);
        }
    }

    private void tryMoveCar(Car car) {
        if (forwardStrategy.canMove()) {
            car.move();
        }
    }

    private Cars createCarsFromUserInput() {
        String carNames = input.input();
        List<String> carNameList = StringToStringListConvertor.convert(carNames);
        List<Car> carList = StringListToCarListConvertor.convert(carNameList);
        return new Cars(carList);
    }

    private void displayRoundResults(Cars cars) {
        List<RoundResultDto> carsInformation = cars.getCarsInformation();
        String roundDto = RoundResultFormatter.format(carsInformation);
        output.print(roundDto);
    }

    private void displayRaceWinners(Cars cars) {
        WinnerDto winners = carRaceResultEvaluator.getWinners(cars);
        String winner = WinnerFormatter.format(winners);
        output.print(winner);
    }

}
