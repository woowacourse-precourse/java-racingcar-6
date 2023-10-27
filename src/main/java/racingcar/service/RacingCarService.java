package racingcar.service;

import racingcar.domain.RacingCars;
import racingcar.repository.RacingCarsRepository;

public class RacingCarService {

    private final RacingCarsRepository racingCarsRepository;

    public RacingCarService(final RacingCarsRepository racingCarsRepository) {
        this.racingCarsRepository = racingCarsRepository;
    }

    public void saveRacingCars(final RacingCars racingCars) {
        racingCarsRepository.save(racingCars);
    }
}
