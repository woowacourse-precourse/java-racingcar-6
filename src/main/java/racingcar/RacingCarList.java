package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarList {
    private List<Car> cars = new ArrayList<>();
    private final User user;
    private final Car car;
    public RacingCarList(User user, Car car) {
        this.user = user;
        this.car = car;
    }
    public List<Car> getRacingCarList() {
        int carCount = getCarCount();
        for (int i = 0; i < carCount; i++) {
            cars.add(car.createNewCar());
        }
        return cars;
    }
    private int getCarCount() {
        return Integer.parseInt(user.inputCarCount());
    }
}
