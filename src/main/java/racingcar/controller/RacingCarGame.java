package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Number;
import racingcar.view.Input;
import racingcar.view.Output;

public class RacingCarGame {

    Car cars;

    public void startGame() {
        // 짧게 수정 필요!
        Output.printStartMessage();
        cars = new Car(Input.inputCarName());
        Validation.validateCarName(cars);
        Output.printAttemptNumberMessage();

        // 수정 필요
        String number = Input.inputNumberMove();
        int num = Integer.parseInt(number);

        Validation.validateNumber(number);
        Output.printResult();

        // 수정 필요
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < cars.getSize(); j++) {
                if (checkNumberIs4Over(Number.generateNumber())) {
                    System.out.println(cars.getNames().get(j));
                    cars.increaseMove(j);
                }
            }
            Output.printRacing();
        }

        Output.printWinners();

    }

    public static boolean checkNumberIs4Over(int number) {
        return number >= 4;
    }


}
