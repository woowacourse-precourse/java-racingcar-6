package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;

public class CarService {

    private final CarRepository carRepository = new CarRepository();

    public void save(List<String> carNames) {
        carNames.stream()
                .map(Car::new)
                .forEach(carRepository::save);
    }

    public void forward() {
        List<Car> cars = carRepository.getCars();
        for (Car car : cars) {
            int randomNum = createRandomNum();
            updateCarScore(car, randomNum);
        }
    }

    private int createRandomNum() {
        return Randoms.pickNumberInRange(0,9);
    }

    public void updateCarScore(Car car, int randomNum) {
        if (randomNum >= 4) {
            car.updateScore();
        }
    }
}
