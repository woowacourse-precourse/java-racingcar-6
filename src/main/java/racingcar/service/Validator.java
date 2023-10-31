package racingcar.service;

import java.util.List;
import racingcar.model.Car;
import racingcar.util.Constant;

public class Validator {

    public void validate(List<Car> carsList) {
        for (Car car : carsList) {
            String name = car.carName();
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름을 입력해주세요");
            }
            if (name.length() > Constant.VALIDATE_LENGTH) {
                throw new IllegalArgumentException("이름은 5자 이하로 입력해주세요.");
            }


        }
    }
}