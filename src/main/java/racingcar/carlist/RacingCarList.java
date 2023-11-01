package racingcar.carlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.car.Car;
import racingcar.user.User;

public class RacingCarList {
    private List<Car> racingCarList;
    private User user;
    public RacingCarList(User user) {
        this.user = user;
        racingCarList = new ArrayList<>();
    }
    public void addNewRacingCar(Car car) {
        String[] carNames = user.getRacingCarNames();

        for (String carName : carNames) {
            racingCarList.add(new Car(carName));
        }
    }
    public List<Car> getRacingCarList() {
        return racingCarList;
    }
}
