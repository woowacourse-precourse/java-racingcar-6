package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.validator.Validator;
import racingcar.view.Input;

public class RaceController {

    final private CarController carController = new CarController();
    final private Validator validator = new Validator();

    public void start() {
        // 자동차 이름
        List<String> names = Input.getCarNames();
        validator.validateCar(names);

        // 차 생성
        List<Car> cars = carController.createCars(names);

        // 회차 입력
        int count = validator.validateCount(Input.getCount());

        // 경기 시작
        carController.race(cars, count);


    }
}
