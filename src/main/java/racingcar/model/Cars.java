package racingcar.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> carList;

    public Cars(List<String> carNames) {
        this.carList = carNames.stream().map(Car::new).collect(Collectors.toList());
    }

    public List<String> getMostForwardedCars() {
        sortCarsByForwards();

        int maxForwards = this.carList.get(0).getForwards();
        return this.carList.stream().filter(car -> car.getForwards() == maxForwards).map(car -> car.getName())
                .collect(Collectors.toList());
    }

    private void sortCarsByForwards() {
        Collections.sort(carList, (car1, car2) -> car2.getForwards() - car1.getForwards());
    }

    public List<Car> getCarList() {
        return carList;
    }
}
