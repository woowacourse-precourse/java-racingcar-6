package racingcar.controller;

import java.util.List;
import racingcar.dto.MoveResultDto;
import racingcar.model.Car;
import racingcar.model.CarCreator;
import racingcar.model.RaceManager;
import racingcar.view.View;
import racingcar.view.constant.Prompt;
import racingcar.view.constant.Result;
import racingcar.view.constant.Winner;

public class Game {

    public static void start() {
        View.printMessage(Prompt.CAR_NAME_INPUT);
        String carNamesString = View.getInput();
        List<String> carNames = CarCreator.splitCarNamesString(carNamesString);
        CarCreator.validateCarNames(carNames);
        List<Car> cars = CarCreator.createCars(carNames);

        View.printMessage(Prompt.NUMBER_OF_MOVE_INPUT);
        String numberOfMoveInput = View.getInput();
        int numberOfMove = RaceManager.validateNumberOfMove(numberOfMoveInput);

        View.printMessage(Prompt.RACE_RESULT);
        startRace(cars, numberOfMove);

        List<String> winnerList = RaceManager.decideWinner(cars);
        View.printMessage(Winner.announcement(winnerList));
    }

    private static void startRace(List<Car> cars, int numberOfMove) {
        for (int i = 0; i < numberOfMove; i++) {
            List<MoveResultDto> moveResultDtos = cars.stream()
                    .map(Car::move)
                    .toList();
            View.printMessage(Result.announcement(moveResultDtos));
        }
    }
}
