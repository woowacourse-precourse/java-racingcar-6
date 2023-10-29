package racingcar.controller;

import java.util.List;
import racingcar.dto.MoveResultDto;
import racingcar.model.Car;
import racingcar.model.CarCreator;
import racingcar.model.RaceManager;
import racingcar.view.View;

public class Game {

    public static void start() {
        String carNamesString = View.getInput();
        List<String> carNames = CarCreator.splitCarNamesString(carNamesString);
        CarCreator.validateCarNames(carNames);
        List<Car> cars = CarCreator.createCars(carNames);

        String numberOfMoveInput = View.getInput();
        int numberOfMove = RaceManager.validateNumberOfMove(numberOfMoveInput);

        startRace(cars, numberOfMove);

        List<String> winnerList = RaceManager.decideWinner(cars);
    }

    private static void startRace(List<Car> cars, int numberOfMove) {
        for (int i = 0; i < numberOfMove; i++) {
            List<MoveResultDto> moveResultDtos = cars.stream()
                    .map(Car::move)
                    .toList();
        }
    }
}
