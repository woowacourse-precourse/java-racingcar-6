package racingcar.service;

import racingcar.repository.CarRepository;

import java.util.List;

public class RacingService {

    private RacingService() {}

    private static class RacingServiceCreater {
        private static final RacingService INSTANCE = new RacingService();
    }

    public static RacingService getInstance() { return RacingServiceCreater.INSTANCE; }

    private final static CarRepository carRepository = CarRepository.getInstance();

    public void startRound(List<String> carNames, int tryCount) {
        createRacingCars(carNames);
    }

    private void createRacingCars(List<String> carNames) {
        carRepository.createCars(carNames);
    }
}
