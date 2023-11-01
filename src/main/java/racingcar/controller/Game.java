package racingcar.controller;

import racingcar.domain.Race;
import racingcar.model.ListOfCar;
import racingcar.view.Output;
import racingcar.view.Input;

public class Game {
    public static void play() {
        ListOfCar cars = new ListOfCar(Input.setName());

        int numOfTime = Input.setNumOfTime();
        for (int i = 0; i < numOfTime; i++) {
            Race.race(cars);
            Output.printResult(cars);
        }
        Output.printWinner(cars);
    }
}
