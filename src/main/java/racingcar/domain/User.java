package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {

    private static final int MAX_NAME_SIZE=5;

    public List<Car> nameForCar(String names) {
        List<String> carsName=separateNames(names);
        List<Car> cars=new ArrayList<>();
        carsName.stream().forEach(name->cars.add(new Car(name.trim())));
        return cars;
    }

    public int fillInMovingNumber() {
        return 0;
    }

    public boolean validateName(String name) {
        return name.length()<=MAX_NAME_SIZE;
    }

    public List<String> separateNames(String names) {
        String[] temp = names.split(",");
        List<String> cars = new ArrayList<>(Arrays.asList(temp));
        return cars;
    }


}
