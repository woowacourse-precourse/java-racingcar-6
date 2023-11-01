package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.validation.Validator;

public class Cars {

    private static final String NAME_DELIMITER = ",";
    private List<Car> carList = new ArrayList<>();
    ;
    Validator validator = new Validator();

    public Cars(String names) {
        List<String> nameList = List.of(names.split(NAME_DELIMITER));
        nameListValidate(nameList);
        for (String name : nameList) {
            nameValidate(name);
            carList.add(new Car(name));
        }
    }

    public List<Car> getCars() {
        return carList;
    }

    public List<String> getWinners() {
        List<String> winnerList = calculateWinners();
        return winnerList;
    }

    public void moveCars() {
        for (Car car : carList) {
            car.setMovement();
        }
    }

    private List<String> calculateWinners() {
        List<String> winnerList = new ArrayList<>();
        int max = findMaxMovement();
        for (Car car : carList) {
            if (car.getMovement() == max) {
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }

    private int findMaxMovement() {
        int max = Integer.MIN_VALUE;
        for (Car car : carList) {
            max = Math.max(max, car.getMovement());
        }
        return max;
    }

    private void nameListValidate(List<String> nameList) {
        validator.isNullList(nameList);
        validator.isDuplicatedName(nameList);
    }

    private void nameValidate(String name) {
        validator.isNull(name);
        validator.isMaxLengthExceeded(name);
    }
}
