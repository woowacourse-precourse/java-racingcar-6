package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Converter {

    public List<String> separatedStringToList(String s, String separator) {
        String[] result = s.split(separator);
        return new ArrayList<>(Arrays.asList(result));
    }

    public List<Car> nameListToCarList(List<String> nameList) {
        List<Car> carList = new ArrayList<>();

        for (String name : nameList) {
            carList.add(new Car(name));
        }

        return carList;
    }
}
