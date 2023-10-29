package controller.dto;

import java.util.List;

public class CarNames {

    private static final String CAR_NAME_SEPARATOR = ",";

    private final List<String> carNames;

    private CarNames(final List<String> carNames) {
        this.carNames = carNames;
    }

    public static CarNames of(final String value) {
        List<String> carNameValues = List.of(value.split(CAR_NAME_SEPARATOR));
        return new CarNames(carNameValues);
    }

    public List<String> getCarNames() {
        return carNames;
    }
}
