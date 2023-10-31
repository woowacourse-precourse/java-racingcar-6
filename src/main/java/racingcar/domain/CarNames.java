package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.validator.Validator;

/*
 *   여러개의 이름 입력을 담당(일급컬렉션)
 * */

public class CarNames {
    private static final String SPLIT_SIGN = ",";
    private final List<CarName> names;

    private CarNames(List<CarName> names) {
        validateCarNames(names);
        this.names = names;
    }

    public static CarNames fromInput(String input) {
        List<String> splitInput = inputSplitBySign(input);
        List<CarName> carNames = splitInput.stream()
                .map(CarName::new)
                .toList();
        return new CarNames(carNames);
    }

    private static List<String> inputSplitBySign(String input) {
        return Arrays.stream(input.split(SPLIT_SIGN)).toList();
    }

    private void validateCarNames(List<CarName> carNames) {
        List<String> namesToString = carNames.stream()
                .map(CarName::getValue)
                .toList();
        Validator.commandsSizeZero(namesToString);
        Validator.commandsNotDuplicated(namesToString);
    }
    //일급컬렉션의 불변성을 지키기위해 getter 제거

    public List<Car> createCars() {
        List<Car> cars = new ArrayList<>();
        for (CarName name : names) {
            cars.add(Car.from(name));
        }
        return cars;
    }
}
