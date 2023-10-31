package racingcar;

import racingcar.model.Car;
import racingcar.service.CarService;
import racingcar.view.View;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현


        CarService carService = new CarService();
        View view = new View(carService);

    }
}
