package racingcar.view;

import racingcar.controller.CarController;

public class OutputView {
    public static String displayCarPosition(CarController controller) {
        StringBuilder display = new StringBuilder();
        display.append(controller.getCarName()).append(" : ");

        for (int i = 0; i < controller.getCarPosition(); i++) {
            display.append("-");
        }

        return display.toString();
    }
}
