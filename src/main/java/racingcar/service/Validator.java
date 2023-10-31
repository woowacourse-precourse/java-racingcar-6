package racingcar.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.model.Car;
import racingcar.util.Constant;

public class Validator {

    public void validate(List<Car> carsList) {
        Set<String> carNames = new HashSet<>();
        for (Car car : carsList) {
            String name = car.carName();
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름을 입력해주세요");
            }
            if (name.length() > Constant.VALIDATE_LENGTH) {
                throw new IllegalArgumentException("이름은 5자 이하로 입력해주세요");
            }
            if (!carNames.add(name)) {
                throw new IllegalArgumentException("이름은 중복되지 않아야 합니다");
            }
        }
    }
}