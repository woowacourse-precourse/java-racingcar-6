package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    public final List<Car> carsList = new ArrayList<>();

    public Cars(String carNames) {
        List<String> carNameList= splitCarNames(carNames);

        carNameList.forEach(carName -> carsList.add(new Car(carName)));
    }

    private List<String> splitCarNames(String carNames) {
        return Arrays.stream(carNames.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public List<Car> getCarsList() {
        return carsList;
    }
}
