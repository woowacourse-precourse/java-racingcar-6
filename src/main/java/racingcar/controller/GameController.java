package racingcar.controller;

import static racingcar.view.InputView.*;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Number;

public class GameController {
    private List<Car> cars = new ArrayList<>();
    private Number round;
    private Referee referee;
    private void setUp() {
        List<String> userInput = askCarNames();
        for (String s : userInput) {
            cars.add(Car.createCar(s));
        }
        round = Number.inputUserRounds();
        System.out.println(cars);
        referee = new Referee(cars);
    }

    public void play() {
        setUp();
        for (int i = 0; i < round.getNumber();i++) {
            referee.proceedRound();
            for (Car c: cars) {
                System.out.println(c.convertPositionToString());
            }
        }

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
