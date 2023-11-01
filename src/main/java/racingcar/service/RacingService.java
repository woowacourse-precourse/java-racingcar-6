package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
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

    public List<Car> processRound() {
        List<Car> cars = carRepository.getCars();
        for (Car car : cars) {
            int randomNum = Randoms.pickNumberInRange(0,9);
            car.moveForward(randomNum);
        }
        return cars;
    }

    private void createRacingCars(List<String> carNames) {
        carRepository.createCars(carNames);
    }
}
