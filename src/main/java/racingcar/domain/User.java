package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {

    public List<Car> nameForCar(String names) {
        List<String> carsName=separateNames(names);
        List<Car> cars=new ArrayList<>();
        carsName.stream().forEach(name->cars.add(new Car(name)));
        return cars;
    }

    public int fillInMovingNumber() {
        return 0;
    }

    public boolean validateName(int name) {
        return false;
    }

    public List<String> separateNames(String names) {
        String[] temp = names.split(",");
        List<String> cars = new ArrayList<>(Arrays.asList(temp));
        return cars;
    }


}
