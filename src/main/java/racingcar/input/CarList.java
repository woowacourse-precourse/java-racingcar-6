package racingcar.input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.output.MessageType;
import racingcar.output.OutputCarRace;

public class CarList {
    private List<Car> cars = new ArrayList<>();

    public static CarList inputCarList(String stringCarNames) {
        return new CarList(stringCarNames);
    }

    private CarList(String stringCarNames) {
        OutputCarRace.print(MessageType.INPUT_CAR_NAME_PRINT);

        List<String> carNameList = Arrays.asList(stringCarNames.split(","));
        cars = carNameList.stream()
                .map(Car::inputCarname)
                .collect(Collectors.toList());

        InputValidator.validateCarList(cars);

        OutputCarRace.printf(MessageType.INPUT_DATA_PRINT, stringCarNames);
    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(cars);
    }
}
