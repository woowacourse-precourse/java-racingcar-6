package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.common.strategy.MoveStrategy;
import racingcar.common.util.DTOFactory;
import racingcar.dto.output.RoundDTO;

public class RacingCars {
    private final List<Car> cars;

    // 자동차 생성
    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    // 자동차 이동
    public void move(MoveStrategy moveStrategy) {
        cars.forEach(car -> car.move(moveStrategy));
    }

    // 라운드 결과
    public List<RoundDTO> getRoundResults() {
        return cars.stream()
                .map(car -> DTOFactory.createRoundDTO(car.getName(), car.getDistance()))
                .collect(Collectors.toList());
    }
}
