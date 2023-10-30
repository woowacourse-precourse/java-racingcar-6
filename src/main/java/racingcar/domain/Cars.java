package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> carList = new ArrayList<>();

    private Cars() {
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void addCar(Car car) {
        carList.add(car);
    }

    public static Cars createCars() {
        return new Cars();
    }


    public static class Car {
        private String name;
        private int distance;

        public Car(String name, int distance) {
            this.name = name;
            this.distance = distance;
        }

        public String getName() {
            return name;
        }

        public int getDistance() {
            return distance;
        }

        public void moveCar(int moveDistance) {
            this.distance += moveDistance;
        }
    }
}
