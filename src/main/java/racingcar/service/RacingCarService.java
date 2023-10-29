package racingcar.service;

import racingcar.domain.RacingCars;
import racingcar.domain.TryCount;
import racingcar.domain.Winners;
import racingcar.repository.DomainRepository;
import racingcar.utils.RandomNumberGenerator;

import java.util.List;

public class RacingCarService {

    private final DomainRepository<RacingCars> racingCarsRepository;
    private final DomainRepository<TryCount> tryCountRepository;
    private final RandomNumberGenerator randomNumberGenerator;

    public RacingCarService(
            final DomainRepository<RacingCars> racingCarsRepository,
            final DomainRepository<TryCount> tryCountRepository,
            final RandomNumberGenerator randomNumberGenerator) {
        this.racingCarsRepository = racingCarsRepository;
        this.tryCountRepository = tryCountRepository;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void saveRacingCars(final RacingCars racingCars) {
        racingCarsRepository.save(racingCars);
    }

    public void saveTryCount(final TryCount tryCount) {
        tryCountRepository.save(tryCount);
    }

    public RacingCars move() {
        final RacingCars racingCars = racingCarsRepository.find();
        final List<Integer> numbers =
                randomNumberGenerator.generateWithSize(racingCars.numOfElement());
        racingCars.moveByNumbers(numbers);
        return racingCars;
    }

    public TryCount findTryCount() {
        return tryCountRepository.find();
    }

    public Winners checkWinners() {
        final RacingCars racingCars = racingCarsRepository.find();
        return racingCars.findWinners();
    }
}
