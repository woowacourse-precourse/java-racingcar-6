package racingcar;

import racingcar.Controller.CarController;
import racingcar.Model.Car;
import racingcar.View.InputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        CarController carController = new CarController();
        carController.start();
    }
}
