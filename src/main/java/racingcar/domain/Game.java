package racingcar.domain;

import java.util.ArrayList;

public class Game {
    ArrayList<Car> carList;
    int moveNumber;

    public Game(ArrayList<Car> carList, int moveNumber) {
        this.carList = carList;
        this.moveNumber = moveNumber;
    }
}
