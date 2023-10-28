package racingcar.view;

import java.util.stream.Collectors;
import racingcar.controller.CarController;
import racingcar.model.Car;

public class OutputView {
    public static String displayCarPosition(CarController controller) {
        return controller.getCars().stream()
                .map(car -> car.getName() + " : " + "-".repeat(car.getPosition()) + System.lineSeparator())
                .collect(Collectors.joining());
    }
}
