package racingcar.game;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private String name;
    private String distance;

    public Car(String name) {
        this.name = name;
        this.distance = "";
    }

    public void move() {
        this.distance += "-";
    }

    public List<Car> generateCarList(List<String> nameList) {
        List<Car> carList = new ArrayList<>();

        nameList.forEach(name -> {
            carList.add(new Car(name));
        });
        return carList;
    }

    public String getName() {
        return this.name;
    }

    public String getDistance() {
        return this.distance;
    }
}
