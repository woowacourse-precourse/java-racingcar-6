package racingcar.model;

import java.util.ArrayList;

public class NameToClass {

    private final ArrayList<Car> classList = new ArrayList<>();

    public NameToClass(ArrayList<String> nameList) {

        for (String name : nameList) {

            Car car = new Car(name);
            classList.add(car);

        }

    }

    public ArrayList<Car> getClassList() {
        return classList;
    }

}
