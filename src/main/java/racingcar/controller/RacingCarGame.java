package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.Input;
import racingcar.view.Output;

public class RacingCarGame {

    Car cars;

    public void startGame() {
        Output.printStartMessage();
        cars = new Car(Input.inputCarName());
        Validation.validateCarName(cars);
        Output.printAttemptNumberMessage();
        String number = Input.inputNumberMove();
        Validation.validateNumber(number);
        Output.printResult();


    }

    public static boolean checkNumberIs4Over(int number) {
        return number >= 4;
    }


}
