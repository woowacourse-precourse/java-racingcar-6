package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Converter {

    private Converter() {
    }

    public static List<String> separatedStringToList(String s, String separator) {
        String[] result = s.split(separator);
        return new ArrayList<>(Arrays.asList(result));
    }

    public static List<Car> nameListToCarList(List<String> nameList) {
        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < nameList.size(); i++) {
            carList.add(new Car(i, nameList.get(i)));
        }

        return carList;
    }
}
