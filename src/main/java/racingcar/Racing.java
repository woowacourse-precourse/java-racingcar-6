package racingcar;

import java.util.ArrayList;

public class Racing {

    ArrayList<Car> cars = new ArrayList<>();
    int count;

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

    public void registCount(String count) {

        this.count = Integer.parseInt(count);
        System.out.println();
    }

}
