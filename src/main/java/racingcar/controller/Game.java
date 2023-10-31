package racingcar.controller;

import racingcar.repository.Car;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Car> carList = new ArrayList<>();
    private int round;

    public void run() {
        Output.askNamesMessage();
        List<String> nameList = Input.carNames();

        for (String name : nameList) {
            carList.add(new Car(name));
        }

        Output.askRoundMessage();
        round = Input.round();

        Output.resultMessage();
        while (round > 0) {
            Move.race(carList);
            Output.racingMessage(carList);
            round--;
        }

        List<String> winnerList = PickWinner.compareDistance(carList);
        Output.winnerMessage(winnerList);
    }
}
