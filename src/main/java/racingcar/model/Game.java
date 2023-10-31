package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Car> carList = new ArrayList<Car>();
    private int userTry = 0;
    static final String DELIMITER = ",";
    static final int RANGE_START = 0;
    static final int RANGE_END = 9;
    static final int STANDARD = 4;

    public static String getDELIMITER() {
        return DELIMITER;
    }

    public void setUserTry(int userTry) {
        this.userTry = userTry;
    }

    public int getUserTry() {
        return this.userTry;
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public void addCarList(String name) {
        Car car = new Car(name);
        this.carList.add(car);
    }

    public void moveCars() {
        for (Car car : this.carList) {
            car.move(randomNumber(), STANDARD);
        }
    }

    public int randomNumber() {
        return Randoms.pickNumberInRange(RANGE_START, RANGE_END);
    }

    private int getMaxDistance() {
        int max = 0;
        for (Car car : this.carList) {
            if (max < car.getDistance()) {
                max = car.getDistance();
            }
        }
        return max;
    }
}
