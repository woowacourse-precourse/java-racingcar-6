package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarStatusDto;

public class RacingCars {
    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        cars.forEach(car -> car.move(getMoveCondition()));
    }

    public List<CarStatusDto> createRacingResult() {
        return cars.stream()
                .map(car -> new CarStatusDto(car.getName(), car.getPosition()))
                .collect(Collectors.toList());
    }

    private int getMoveCondition() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
