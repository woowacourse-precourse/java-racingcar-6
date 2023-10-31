package racingcar.util;

import java.util.Arrays;
import java.util.List;
import racingcar.constants.Constants;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Name;
import racingcar.model.Position;
import racingcar.util.validator.CarsValidator;

public enum CarsGenerator {
    INSTANCE;
    private static final String EMPTY = "";

    public Cars generate(String inputNames) {
        List<String> carNames = Arrays.stream(splitNames(inputNames))
                .map(this::removeWhiteSpace)
                .toList();

        CarsValidator.INSTANCE.validate(carNames);

        return new Cars(toCars(carNames));
    }

    private String[] splitNames(String names) {
        return names.split(Constants.COMMA);
    }

    private String removeWhiteSpace(String name) {
        return name.replace(Constants.WHITESPACE, EMPTY);
    }

    private List<Car> toCars(List<String> names) {
        return names.stream()
                .map(Name::new)
                .map(this::createCar)
                .toList();
    }

    private Car createCar(Name name) {
        return new Car(name, createPosition());
    }

    private Position createPosition() {
        return new Position();
    }
}
