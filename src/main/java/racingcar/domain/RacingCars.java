package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarStatusDto;
import racingcar.enums.Movement;

public class RacingCars {
    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        cars.forEach(car -> car.move(getMoveCondition()));
    }

    private int getMoveCondition() {
        return Randoms.pickNumberInRange(Movement.MIN_MOVE_RANGE.getValue(), Movement.MAX_MOVE_RANGE.getValue());
    }

    public List<CarStatusDto> submitCarStatuses() {
        List<CarStatusDto> carStatuses = cars.stream()
                .map(car -> new CarStatusDto(car.getName(), car.getPosition()))
                .collect(Collectors.toList());
        return Collections.unmodifiableList(carStatuses);
    }
}
