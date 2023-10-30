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

    public int setRoundNum(String inputRoundNum) {
        return Integer.parseInt(inputRoundNum);
    }

    public void moveCar(List<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            if (checkMoveOrStop() == Movement.MOVE) {
                carList.get(i).moveCount++;
            }
        }
    }
}

