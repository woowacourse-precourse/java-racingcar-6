package racingcar.model.repository;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.domain.Car;
import racingcar.view.OutputView;

public class CarRepository {
    List<Car> cars;

    public CarRepository() {
        cars = new ArrayList<>();
    }

    public void save(String name) {
        cars.add(new Car(name));
    }

    public void carForward() {
        cars.forEach(car -> {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.setForward(car.getForward() + 1);
            }
            OutputView.outputForward(car);
        });
    }

    public List<String> findAllMaxForward() {
        int maxForward = cars.stream()
                .mapToInt(Car::getForward)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getForward() == maxForward)
                .map(Car :: getName)
                .collect(Collectors.toList());
    }
}
