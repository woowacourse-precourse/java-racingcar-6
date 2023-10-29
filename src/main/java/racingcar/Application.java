package racingcar;

import racingcar.domain.AppConfig;
import racingcar.domain.car.dao.CarRepository;
import racingcar.domain.car.controller.CarController;
import racingcar.domain.car.service.CarService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AppConfig.getController().process();
    }
}
