package racingcar.view;

import java.util.stream.Collectors;
import racingcar.controller.CarController;
import racingcar.model.Car;

public class OutputView {
    public static String displayCarPosition(CarController controller) {
        return controller.getCarDtos().stream()
                .map(carDto -> carDto.getName() + " : " + "-".repeat(carDto.getPosition()) + System.lineSeparator())
                .collect(Collectors.joining());
    }
}
