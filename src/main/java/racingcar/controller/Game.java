package racingcar.controller;

import java.util.List;
import racingcar.dto.MoveResultDto;
import racingcar.model.CarNames;
import racingcar.model.Cars;
import racingcar.model.NumberOfMove;
import racingcar.view.View;
import racingcar.view.constant.Prompt;
import racingcar.view.constant.Result;
import racingcar.view.constant.Winner;

public class Game {

    public static void start() {
        Cars cars = createCars();
        startRace(cars, setNumberOfMove());
        announceWinner(cars);
    }

    private static Cars createCars() {
        View.printMessage(Prompt.CAR_NAME_INPUT);
        String carNamesString = View.getInput();
        CarNames carNames = CarNames.create(carNamesString);
        return Cars.createWithNames(carNames);
    }

    private static NumberOfMove setNumberOfMove() {
        View.printMessage(Prompt.NUMBER_OF_MOVE_INPUT);
        String numberOfMoveInput = View.getInput();
        return NumberOfMove.create(numberOfMoveInput);
    }

    private static void startRace(Cars cars, NumberOfMove numberOfMove) {
        View.printMessage(Prompt.RACE_RESULT);
        while (numberOfMove.isLeft()) {
            List<MoveResultDto> moveResultDtos = cars.getMoveResultDTOs();
            View.printMessage(Result.announcement(moveResultDtos));
        }
    }

    private static void announceWinner(Cars cars) {
        List<String> winnerList = cars.getWinner();
        View.printMessage(Winner.announcement(winnerList));
    }
}
