package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private String name;
    private int moveCount;

    public Car(String name, int moveCount) {
        this.name = name;
        this.moveCount = moveCount;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    public static List<Car> initialize() {
        List<String> carNames = User.splitInput(User.input());
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName, 0);
            cars.add(car);
        }
        return cars;
    }

    public static void checkLength(List<Car> carList) {
        for (Car car : carList) {
            String carName = car.getName();
            if (carName.length() > MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 5글자 이하로 작성해주세요.");
            }
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
