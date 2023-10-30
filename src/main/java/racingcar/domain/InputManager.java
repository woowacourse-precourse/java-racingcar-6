package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.Car;

public class InputManager {
    private final int gameProcessCount;
    private final String inputCarList;
    private final List<Car> parsedCarList;

    public InputManager(int gameProcessCount, String inputCarList) {
        this.gameProcessCount = gameProcessCount;
        this.inputCarList = inputCarList;
        this.parsedCarList = parseCarList(inputCarList);
    }

    public int getGameProcessCount() {
        return gameProcessCount;
    }

    public List<Car> getParsedCarList() {
        return parsedCarList;
    }

    private List<Car> parseCarList(String carList) {
        List<Car> cars = new ArrayList<>();
        String[] carNames = carList.split(",");
        for (String carName : carNames) {
            carNameLengthValidate(carName);
            cars.add(new Car(carName));
        }
        return cars;
    }

    private void carNameLengthValidate(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5글자를 넘을 수 없습니다.");
        }
    }
}
