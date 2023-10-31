package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.dto.CarResultResponse;
import racingcar.repository.RacingCarRepository;
import racingcar.utils.RandomNumberGenerator;

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

    public List<CarResultResponse> processMove() {
        List<Car> cars = racingCarRepository.findAll();

        for (Car car : cars) {
            int randomNumber = RandomNumberGenerator.generate();
            car.move(randomNumber);
        }

        return cars.stream()
            .map(car -> new CarResultResponse(car.getName(), car.getMovingCount()))
            .toList();
    }

    public List<String> getWinnerNames() {
        List<Car> cars = racingCarRepository.findAll();

        int maxMovingCount = getMaxMovingCount(cars);

        return cars.stream()
            .filter(car -> car.getMovingCount() == maxMovingCount)
            .map(Car::getName)
            .toList();
    }

    private int getMaxMovingCount(List<Car> cars) {
        return cars.stream()
            .mapToInt(Car::getMovingCount)
            .max()
            .getAsInt();
    }
}
