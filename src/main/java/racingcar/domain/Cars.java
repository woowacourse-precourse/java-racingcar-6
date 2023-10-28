package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public void addCar(String name){
        cars.add(new Car(name));
    }

    public void getCars() {
        for (Car c: cars){
            System.out.println(c);
        }
    }
}
