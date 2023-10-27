package racingcar.racingcar;

import java.util.List;

/**
 * @author 민경수
 * @description racing car
 * @since 2023.10.27
 **********************************************************************************************************************/
public class RacingCar {

    private final List<String> cars;

    public RacingCar(List<String> cars) {
        validateNameLength(cars);
        this.cars = cars;
    }

    /**
     * 이름은 5글자 이하로만 설정할 수 있다.
     */
    private void validateNameLength(List<String> cars) {
        for (String car : cars) {
            if (car.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 공백 포함 5글자를 초과할 수 없습니다. 이름을 확인해주세요. 입력한 이름 : " + car);
            }
        }
    }

}