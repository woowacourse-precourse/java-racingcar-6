package racingcar.controller;

import static racingcar.view.InputView.*;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Number;

public class GameController {
    private List<Car> cars = new ArrayList<>();
    private Number round;
    private void setUp() {
        List<String> userInput = askCarNames();
        for (String s : userInput) {
            cars.add(Car.createCar(s));
        }
        round = Number.inputUserRounds();
    }

    public void play() {
        setUp();
    }
        /*
         *  - one round
         *      throw dice for each car
         *      determine whether car move forward (dice >= 4)
         *      print result
         *  loop rounds according to user input
         *  decide winner
         *  print winner
         *  exit00
         */
}
