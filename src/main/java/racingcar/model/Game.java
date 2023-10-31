package racingcar.model;

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
}
