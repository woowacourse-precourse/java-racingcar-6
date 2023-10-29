package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Car> carList = new ArrayList<>();

    public void registerCar(Car... cars) {
        this.carList.addAll(List.of(cars));
    }

    public void registerCar(List<Car> carList) {
        this.carList.addAll(carList);
    }

    public void proceedCars() {
        for (Car car : carList) {
            if (car.isProceedNext()) {
                car.proceed();
            } else {
                car.stop();
            }
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Car car : carList) {
            sb.append(car.getName())
                    .append(" : ")
                    .append("-".repeat(car.getPosition()))
                    .append('\n');
        }
        return sb.toString();
    }
}
