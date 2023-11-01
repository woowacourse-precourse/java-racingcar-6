package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Registration {

    public List<String> getCarNames(String input) {
        validateCompetitor(input);
        List<String> carNameList = Arrays.asList(input.split(","));
        validateNameLength(carNameList);
        return carNameList;
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

    private void validateNameLength(List<String> carNameList) {
        for (String name : carNameList) {
            if (5 < name.length()) {
                throw new IllegalArgumentException();
            }
        }
    }

}
