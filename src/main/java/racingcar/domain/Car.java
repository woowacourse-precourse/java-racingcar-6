package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Car {

    int id;
    String name;
    int currentPosition = 0;
    List<Integer> pickedNumbers = new ArrayList<>();

    private Car(String name) {
        this.name = name;
    }


    public static Car create(String name) {
        return new Car(name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


}
