package racingcar.model;

import racingcar.util.StringUtil;


import java.util.ArrayList;
import java.util.List;

public class Cars {
    public final List<Car> cars = new ArrayList<>();

    public Cars(String input) {
        ArrayList<String> carList = StringUtil.arrayList(input);
        for (String name : carList) {
            cars.add(new Car(name));
        }
    }

    public void move() {
        for (Car car : cars) {
            car.go();
        }
    }
    public List<Car> getCars() {
        return cars;
    }



}
