package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Registration {

    public List<String> getCarNames(String input) {
        validateCompetitor(input);
        return Arrays.asList(input.split(","));
    }

    public List<Car> createCarList(List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(new Car(name, 0));
        }
        return carList;
    }

    private void validateCompetitor(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException();
        }
    }

}
