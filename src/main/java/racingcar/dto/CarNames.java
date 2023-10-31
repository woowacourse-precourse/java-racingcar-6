package racingcar.dto;

import java.util.List;

public class CarNames {

    private final List<CarName> names;

    private CarNames(List<CarName> names) {
        this.names = names;
    }

    public static CarNames from(List<String> names) {
        return new CarNames(names.stream().map(CarName::new).toList());
    }

    public List<CarName> getNames() {
        return names;
    }
}
