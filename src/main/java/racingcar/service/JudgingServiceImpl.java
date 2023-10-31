package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.repository.MemoryCarRepository;

public class JudgingServiceImpl implements JudgingService {
    CarRepository carRepository = new MemoryCarRepository();
    @Override
    public String determineWinner() {
        List<String> winners = new ArrayList<>();
        List<Car> cars = carRepository.getCarList();

        int maxPosition = findMaxPosition(cars);

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        return String.join(", ", winners);
    }

    @Override
    public int findMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }
}
