package racingcar.Domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    private static final String commaSeparator = ",";

    public Cars(String carNames) {
        List<String> carNameList = splitByComma(carNames);
        cars = carNameList.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> getCarList() {
        return cars;
    }

    private List<String> splitByComma(String carList) {
        return Arrays.stream(carList.split(commaSeparator))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
