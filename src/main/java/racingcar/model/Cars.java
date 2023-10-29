package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final int MIN_VALUE = 0;
    private final int MAX_VALUE = 9;
    private int tryCount;

    private List<Car> carList = new ArrayList<>();

    public List<Car> getCarList() {
        return carList;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void setCarList(String inputString) {
        String[] names = inputString.split(",");

        for (String name : names) {
            Car car = new Car(name.trim());
            carList.add(car);
        }
    }

    public void setTryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
    }

    public void moveCars() {
        for (Car car : carList) {
            car.run(generateRandomNumber());
        }
    }
}
