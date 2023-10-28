package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carList;

    private Cars(List<Car> carList) {
        this.carList = carList;
    }

    public static Cars of(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        return new Cars(cars);
    }

    public void move() {
        for (Car car : carList) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.moveForward(randomNumber);
        }
    }

    public List<String> getCarStatusList() {
        return carList.stream()
                .map(car -> car.getCarStatus())
                .toList();
    }

    public List<String> getWinnerList() {
        int maxPosition = getMaxPosition();

        return carList.stream()
                .filter(car -> car.getPosition()==maxPosition)
                .map(car -> car.getName())
                .toList();
    }

    private int getMaxPosition() {
        return carList.stream()
                .mapToInt(car -> car.getPosition())
                .max()
                .orElse(0);
    }
}
