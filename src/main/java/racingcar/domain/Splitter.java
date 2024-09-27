package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Splitter {

    public List<String> stringToList(String carNameLine) {
        List<String> list = Arrays.asList(carNameLine.split(","));

        return list;
    }

    public List<Car> makeCar(List<String> carNamelist) {
        List<Car> carList = new ArrayList<>();

        for (String carName : carNamelist) {
            Car car = new Car(carName);
            carList.add(car);
        }

        return carList;
    }
}
