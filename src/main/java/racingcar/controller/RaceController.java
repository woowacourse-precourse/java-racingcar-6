package racingcar.controller;

import java.util.List;
import racingcar.validator.Validator;
import racingcar.view.Input;

public class RaceController {

    final CarController carController = new CarController();
    final Validator validator = new Validator();

    public void start() {
        // 자동차 이름 + 회차 입력
        List<String> names = Input.getCarNames();
        validator.validateCar(names);

        // 차 생성


        validator.validateCount(Input.getCount());


    }
}
