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
}
