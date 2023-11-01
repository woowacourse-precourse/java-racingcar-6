package racingcar.service;

import racingcar.repository.Car;
import racingcar.repository.RacingRepository;

import java.util.List;

public class RacingServiceImpl implements RacingService {
    private final RacingRepository racingRepository;
    private final RandomNumberGenerator randomNumberGenerator;
    private static int MIN_NUMBER = 4;

    public RacingServiceImpl(RacingRepository racingRepository, RandomNumberGenerator randomNumberGenerator) {
        this.racingRepository = racingRepository;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public void generateCar(String name) {
        racingRepository.create(new Car(name));
    }

    @Override
    public List<Car> winners() {
        return racingRepository.getWinners();
    }

    @Override
    public List<List<Car>> results() {
        return racingRepository.getRaceResults();
    }

    @Override
    public void race() {
        List<Car> cars = racingRepository.findAll();
        for (Car car : cars) {
            int randomNumber = randomNumberGenerator.pickNumberInRange(0, 9);
            if (randomNumber >= MIN_NUMBER) {
                car.move(1);
            }
        }
        racingRepository.saveRaceResult(cars);
    }
}
