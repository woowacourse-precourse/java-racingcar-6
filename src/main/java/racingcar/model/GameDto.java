package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.ValidatorConstant;
import java.util.List;

public class GameDto {
    private final List<CarDto> cars;

    public GameDto(List<CarDto> cars) {
        this.cars = cars;
    }

    public void run() {
        cars.forEach(car -> car.move(Randoms.pickNumberInRange(ValidatorConstant.MIN_RANDOM_RANGE, ValidatorConstant.MAX_RANDOM_RANGE))
        );
    }

    public List<CarDto> getCarsDto() {
        return cars;
    }
}