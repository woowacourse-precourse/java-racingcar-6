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

    private final Input input;
    private final Output output;

    private final ForwardStrategy forwardStrategy;

    private final CarRaceResultEvaluator carRaceResultEvaluator;

    public CarRace() {
        this.input = new ConsoleInput();
        this.output = new ConsoleOutput();
        this.forwardStrategy = new RandomForwardStrategy();
        this.carRaceResultEvaluator = new CarRaceResultEvaluator();
    }

    @Override
    public void executeRace() {
        output.print(CAR_NAME_PROMPT.getMessage());
        Cars cars = createCarsFromUserInput();
        output.print(TRY_COUNT_PROMPT.getMessage());
        int playCount = StringToIntConvertor.convert(input.input());
        executeRaceRounds(cars, playCount);
        displayRaceWinners(cars);
    }

    private void executeRaceRounds(Cars cars, int playCount) {
        while (playCount-- > 0) {
            cars.move();
            displayRoundResults(cars);
        }
    }

    private Cars createCarsFromUserInput() {
        String carNames = input.input();
        List<String> carNameList = StringToStringListConvertor.convert(carNames);
        List<Car> carList = StringListToCarListConvertor.convert(carNameList, forwardStrategy);
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
