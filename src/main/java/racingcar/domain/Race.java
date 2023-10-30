package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Car> carList = new ArrayList<>();

    public void registerCars(Car... cars) {
        this.carList.addAll(List.of(cars));
    }

    public void registerCars(List<Car> carList) {
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

    public List<Car> getHeadCars() {
        List<Car> resultList = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (Car car : carList) {
            int position = car.getPosition();
            if (position < max) {
                continue;
            }

            if (position > max) {
                resultList.clear();
                max = position;
            }
            resultList.add(car);
        }

        return resultList;
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
