package racingcar.model.car;

import racingcar.constants.Texts;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(String names) {
        cars = new ArrayList<>();
        String[] name = names.split(Texts.COMMAS.toString());
        for (String s : name) {
            Car car = new Car(s);
            cars.add(car);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getMaxCount() {
        int maxCount = 0;
        for (Car car : cars) {
            if (car.getCount() > maxCount) {
                maxCount = car.getCount();
            }
        }
        return maxCount;
    }
}
