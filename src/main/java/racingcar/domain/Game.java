package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {
    ArrayList<Car> carList;
    int moveNumber;

    public Game(ArrayList<Car> carList, int moveNumber) {
        this.carList = carList;
        this.moveNumber = moveNumber;
    }

    public int getMoveNumber() {
        return moveNumber;
    }

    public int getCarNumber() {
        return carList.size();
    }

    public ArrayList<Car> updateDistance(List<Boolean> isMoving) {
        for (int i = 0; i < carList.size(); i++) {
            if (isMoving.get(i)) carList.get(i).move();
        }
        return carList;
    }

    public StringBuilder decideWinner() {
        StringBuilder resultSb = new StringBuilder();
        int maxDistance = 0;
        for (int i = 0; i < getCarNumber(); i++) {
            Car nowCar = carList.get(i);
            if (maxDistance < nowCar.getDistance()) {
                resultSb = new StringBuilder();
                resultSb.append(nowCar.getName());
                maxDistance = nowCar.getDistance();
            } else if (maxDistance == nowCar.getDistance()) {
                resultSb.append(", ");
                resultSb.append(nowCar.getName());
            }
        }
        return resultSb;
    }
}
