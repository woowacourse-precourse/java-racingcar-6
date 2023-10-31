package racingcar.controller.subcontroller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.repository.CarRepository;

public class InitializeCarController {
    public void initializeCar(List<String> names, int tryCount) {
        for (String name : names) {
            Car car = new Car(name, tryCount);
            CarRepository.add(car);
        }
    }
}
