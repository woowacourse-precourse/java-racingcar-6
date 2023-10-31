package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.repository.RacingCarRepository;

public class RacingCarService {

    private final RacingCarRepository racingCarRepository;

    public RacingCarService(RacingCarRepository racingCarRepository) {
        this.racingCarRepository = racingCarRepository;
    }

    public void save(List<String> carNames) {
        racingCarRepository.save(convertToCarList(carNames));
    }

    private static List<Car> convertToCarList(List<String> carNames) {
        return carNames.stream()
            .map(Car::new)
            .toList();
    }
}
