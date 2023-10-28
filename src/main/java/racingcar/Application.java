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
        List<Car> cars = createCars(om, im, carManufacturer);
        int attemptCount = createAttemptCount(om, im);
        startRacing(cars, attemptCount);

    }

    private static void startRacing(List<Car> cars, int attemptCount) {
        for (int i = 0; i < attemptCount; i++) {

        }
    }

    private static int createAttemptCount(OutputManager om, InputManager im) {
        om.printNumberOfAttempts();
        return im.inputAttemptCount();
    }

    private static List<Car> createCars(OutputManager om, InputManager im, CarManufacturer carManufacturer) {
        om.printStartGame();
        return carManufacturer.createCars(im.inputCarNames());
    }
}
