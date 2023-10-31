package racingcar;

import java.util.ArrayList;

public class Racing {

    ArrayList<Car> cars = new ArrayList<>();

    public Racing() {

    }

    public void registCars(String names) {

        names = names.replaceAll(" ", "");
        String[] name = names.split(",");

        for ( String n : name ) {
            Car c = new Car(n, "");
            cars.add(c);
        }
    }
}
