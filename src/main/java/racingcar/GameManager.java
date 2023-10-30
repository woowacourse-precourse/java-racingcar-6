package racingcar;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class GameManager {
    private static GameManager gameManager = new GameManager();

    private GameManager() {}

    public static GameManager getInstance() {
        return gameManager;
    }

    public List<Car> setCarList(String input) {
        StringTokenizer st = new StringTokenizer(input, ",");
        List<Car> carList = new ArrayList<>();
        while (st.hasMoreTokens()) {
            carList.add(new Car(st.nextToken(), 0));
        }
        return carList;
    }
}

