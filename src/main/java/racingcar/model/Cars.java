package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.validation.CommonValidator;
import racingcar.validation.NameValidator;

public class Cars {

    private static final String NAME_DELIMITER = ",";
    private List<Car> carList = new ArrayList<>();
    NameValidator nameValidator = new NameValidator();
    CommonValidator commonValidator = new CommonValidator();

    public Cars(String names) {
        nameValidator.isValidNames(names);
        createCarList(names);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(carList);
    }

    public void moveCars() {
        for (Car car : carList) {
            car.setMovement();
        }
    }

    private void createCarList(String names) {
        List<String> nameList = List.of(names.split(NAME_DELIMITER));
        nameListValidate(nameList);
        for (String name : nameList) {
            nameValidate(name);
            carList.add(new Car(name));
        }
    }

    private void nameListValidate(List<String> nameList) {
        commonValidator.isNullList(nameList);
        nameValidator.isDuplicatedName(nameList);
    }

    private void nameValidate(String name) {
        commonValidator.isNull(name);
        nameValidator.isMaxLengthExceeded(name);
    }
}
