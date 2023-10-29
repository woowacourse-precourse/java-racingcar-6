package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final int MIN_NUM = 0;
    private static final int MAX_NUM = 9;
    private static final int MOVE_NUM = 4;


    private List<Car> cars = new ArrayList<>();
    private int tryCount;

    public List<Car> getCars() {
        return cars;
    }

    public void setTryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public void insertCar(Car car) {
        cars.add(car);
    }

    public void moveAllCar() {
        tryCount--;

        for (Car car : cars) {
            if (Randoms.pickNumberInRange(MIN_NUM, MAX_NUM) >= MOVE_NUM) {
                car.move();
            }
        }
    }


}
