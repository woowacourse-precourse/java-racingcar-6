package controller;

import static enums.PrintMessages.*;

import domain.Car;
import domain.CarRaceResultEvaluator;
import domain.Cars;
import domain.MoveJudgement;
import domain.MoveStrategy;
import dto.RoundResultDto;
import dto.WinnerDto;
import java.util.List;
import util.convertor.StringListToCarListConvertor;
import util.convertor.StringToIntConvertor;
import util.convertor.StringToStringListConvertor;
import util.formatter.RoundResultFormatter;
import util.formatter.WinnerFormatter;
import view.Input;
import view.Output;

public class CarRace implements Race {

    private static final int END_ROUND_COUNT = 0;
    private final Input input;
    private final Output output;

    private final MoveJudgement moveJudgement;

    private final MoveStrategy moveStrategy;

    private final CarRaceResultEvaluator carRaceResultEvaluator = new CarRaceResultEvaluator();

    public CarRace(
            Input input,
            Output output,
            MoveJudgement moveJudgement,
            MoveStrategy moveStrategy) {
        this.input = input;
        this.output = output;
        this.moveJudgement = moveJudgement;
        this.moveStrategy = moveStrategy;
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
        return playCount > END_ROUND_COUNT;
    }

    private void playRound(Cars cars) {
        for (Car car : cars.getAllCars()) {
            tryMoveCar(car);
        }
    }

    private void tryMoveCar(Car car) {
        if (moveJudgement.canMove()) {
            car.move();
        }
    }

    private Cars createCarsFromUserInput() {
        String carNames = input.input();
        List<String> carNameList = StringToStringListConvertor.convert(carNames);
        List<Car> carList = StringListToCarListConvertor.convert(carNameList, moveStrategy);
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
