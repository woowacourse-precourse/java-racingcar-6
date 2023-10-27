package racingcar;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Car> cars = new ArrayList<>();

    public void makeCars(String inputStr) {
        String[] carArrayBeforeFiltering = inputStr.split(",");
        for (int i = 0; i < carArrayBeforeFiltering.length; i++) {
            String carName = carArrayBeforeFiltering[i];
            if (carName.length() <= 5) {
                cars.add(new Car(carName));
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    public void tryDriving(int attemptNum) {
        for (int i = 0; i < attemptNum; i++) {
            for (Car car : cars) {
                car.driving();
                System.out.println(car.getCarName() + " : " + car.getDistanceDriven());
            }
            System.out.println();
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
