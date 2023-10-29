package racingcar.view;

import racingcar.controller.GameController;
import racingcar.message.OutputMessage;
import racingcar.model.Car;

public class OutputView {

    public void round(Car car){
        printMessage(car.getName() + " : ");
        printMessage("-".repeat(car.getPosition()));
        System.out.println();
    }

    private void printMessage(String text) {
        System.out.print(text);
    }
}
