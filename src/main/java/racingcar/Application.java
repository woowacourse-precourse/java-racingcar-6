package racingcar;

import java.util.List;
import racingcar.domain.CarManufacturer;
import racingcar.input.InputManager;
import racingcar.output.OutputManager;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final OutputManager outputManager = new OutputManager();
        final InputManager inputManager = new InputManager();
        final CarManufacturer carManufacturer = new CarManufacturer();
    }
}
