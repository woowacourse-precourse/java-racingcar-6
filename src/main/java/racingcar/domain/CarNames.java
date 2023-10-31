package racingcar.domain;

import java.util.List;
import racingcar.validator.Validator;

/*
 *   자동차 이름 정보를 담당
 * */


public class CarNames {
    private final List<CarName> names;

    private CarNames(List<CarName> names) {
        validateCarNames(names);
        this.names = names;
    }

    public static CarNames from(List<CarName> carNames) {
        return new CarNames(carNames);
    }

    private void validateCarNames(List<CarName> carNames) {
        List<String> namesToString = carNames.stream()
                .map(CarName::getValue)
                .toList();
        // Validator.commandsSizeBiggerThan(0, carNames); 입력받은 이름임 없을때는
        Validator.commandsNotDuplicated(namesToString);
    }
    //일급컬렉션의 불변성을 지키기위해 getter 제거

    public void createCars(List<Car> cars) {
        for (CarName name : names) {
            cars.add(new Car(name));
        }
    }
    

}
