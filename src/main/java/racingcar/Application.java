package racingcar;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarManufacturer;
import racingcar.input.InputManager;
import racingcar.output.OutputManager;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final OutputManager om = new OutputManager();
        final InputManager im = new InputManager();
        final CarManufacturer carManufacturer = new CarManufacturer();
        om.printStartGame();
        List<Car> cars = carManufacturer.createCars(im.inputCarNames());
        om.printNumberOfAttempts();
    }
}
