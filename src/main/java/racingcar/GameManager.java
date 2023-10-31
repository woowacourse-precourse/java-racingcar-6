package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class GameManager {
    private static GameManager gameManager = new GameManager();

    private GameManager() {
    }

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

    public Movement checkMoveOrStop() {
        int num = Randoms.pickNumberInRange(0, 9);
        if (num >= 4) {
            return Movement.MOVE;
        }
        return Movement.STOP;
    }

    public boolean checkGameFinished(int roundNum) {
        if (roundNum == 0) {
            return true;
        }
        return false;
    }

    public List<Car> checkWinner(List<Car> carList) {
        int maxMoveCount = 0;
        List<Car> maxCarList = new ArrayList<>();
        for (int i = 0; i < carList.size(); i++) {
            if (maxMoveCount < carList.get(i).moveCount) {
                maxMoveCount = carList.get(i).moveCount;
            }
        }
        for (int i = 0; i < carList.size(); i++) {
            if (maxMoveCount == carList.get(i).moveCount) {
                maxCarList.add(carList.get(i));
            }
        }
        return maxCarList;
    }
}

