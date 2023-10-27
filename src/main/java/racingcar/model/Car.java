package racingcar.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Car {
    private LinkedHashMap<String, Integer> cars;

    public Car(List<String> carNameInputList) {
        cars = carNameInputList.stream()
                .collect(Collectors.toMap(Function.identity(), e -> 0, (oldValue, newValue) -> newValue,
                        LinkedHashMap::new));
    }
}
