package racingcar.service;

import racingcar.domain.RacingCars;
import racingcar.domain.TryCount;
import racingcar.repository.DomainRepository;

public class RacingCarService {

    private final DomainRepository<RacingCars> racingCarsRepository;
    private final DomainRepository<TryCount> tryCountRepository;

    public RacingCarService(final DomainRepository<RacingCars> racingCarsRepository,
                            final DomainRepository<TryCount> tryCountRepository) {
        this.racingCarsRepository = racingCarsRepository;
        this.tryCountRepository = tryCountRepository;
    }

    public void saveRacingCars(final RacingCars racingCars) {
        racingCarsRepository.save(racingCars);
    }

    public void saveTryCount(final TryCount tryCount) {
        tryCountRepository.save(tryCount);
    }
}
