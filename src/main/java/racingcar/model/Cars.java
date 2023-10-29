package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final int MIN_VALUE = 0;
    private final int MAX_VALUE = 9;

    private List<Car> carList = new ArrayList<>();

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(String inputString) {
        String[] names = inputString.split(",");

        for (String name : names) {
            Car car = new Car(name.trim());
            carList.add(car);
        }
    }

    public void moveCars() {
        for (Car car : carList) {
            car.run(generateRandomNumber());
        }
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
    }
}
