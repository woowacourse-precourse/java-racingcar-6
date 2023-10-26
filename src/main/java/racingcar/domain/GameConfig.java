package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class GameConfig {
    public int moveCount;

    public int getMoveCount() {
        return moveCount;
    }

    public void setMoveCount(int moveCount) {

        if (moveCount < 1) {
            throw new IllegalArgumentException("시도할 회수는 0회 이상이어야 합니다.");
        }

        this.moveCount = moveCount;
    }

    public List<Car> createCars(String carNames) {

        List<Car> cars = new ArrayList<>();
        List<String> checkCarName = new ArrayList<>();

        String[] split = carNames.split(",");
        for (String carName : split) {
            if (1 > carName.length() || carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 1글자 이상, 5글자 미만까지 가능합니다.");
            } else if (checkCarName.contains(carName)) {
                throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
            } else {
                checkCarName.add(carName);
                Car car = new Car(carName.trim());
                cars.add(car);
            }
        }
        return cars;
    }
}
