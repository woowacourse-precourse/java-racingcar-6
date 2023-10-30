package racingcar;

import java.util.Collection;
import java.util.List;

public class RacingCarGame {
    private List<Car> cars;
    private int count;

    public void run() {
        cars = Controller.inputNames();
        count = Controller.inputCount();

        Controller.printResultText();
        for (int i = 0; i < count; i++) {
            moveCars();
            Controller.printCarStates(cars);
        }

        printResult();
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public void printResult() {
        // "최종 우승자 : pobi, jun";
    }

    public List<Car> getWinners() {
        // TODO
        return new List<Car>();
    }
}
