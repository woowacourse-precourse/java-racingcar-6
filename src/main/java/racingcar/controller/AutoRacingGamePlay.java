package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.service.MoveOrStopCar;
import racingcar.view.InputMessage;

public class AutoRacingGamePlay {
    InputMessage inputMessage = new InputMessage();
    MoveOrStopCar moveOrStopCar = new MoveOrStopCar();

    public void racingGamePlay() {
        List<String> inputCarNames = inputMessage.userInputCarName();
        Integer inputNumberAttempts = inputMessage.userInputNumberOfAttempts();

        List<Car> cars = inputCarNames.stream().map(item -> {
            return new Car(item, 0);
        }).collect(Collectors.toList());

        moveOrStopCar.moveOrStopCarsForGivenTimes(inputNumberAttempts, cars);
    }
}
