package racingcar.controller;

import java.util.List;
import racingcar.dto.MoveResultDto;
import racingcar.model.Car;
import racingcar.model.CarNames;
import racingcar.model.Cars;
import racingcar.model.RaceManager;
import racingcar.view.View;
import racingcar.view.constant.Prompt;
import racingcar.view.constant.Result;
import racingcar.view.constant.Winner;

public class Game {

    public static void start() {
        List<Car> cars = createCars();
        int numberOfMove = setNumberOfMove();
        startRace(cars, numberOfMove);
        announceWinner(cars);
    }

    private static List<Car> createCars() {
        View.printMessage(Prompt.CAR_NAME_INPUT);
        String carNamesString = View.getInput();
        CarNames carNames = CarNames.create(carNamesString);
        return Cars.withName(carNames);
    }

    private static int setNumberOfMove() {
        View.printMessage(Prompt.NUMBER_OF_MOVE_INPUT);
        String numberOfMoveInput = View.getInput();
        return RaceManager.validateNumberOfMove(numberOfMoveInput);
    }

    private static void startRace(List<Car> cars, int numberOfMove) {
        View.printMessage(Prompt.RACE_RESULT);
        for (int i = 0; i < numberOfMove; i++) {
            List<MoveResultDto> moveResultDtos = cars.stream().map(Car::move).toList();
            View.printMessage(Result.announcement(moveResultDtos));
        }
    }

    private static void announceWinner(List<Car> cars) {
        List<String> winnerList = RaceManager.decideWinner(cars);
        View.printMessage(Winner.announcement(winnerList));
    }
}
