package racingcar.service;

import java.util.List;
import racingcar.model.CarList;

public class GameService {
    CarList carList = new CarList();

    public void start() {
        this.setGame();
        this.runGame();
    }

    private void setGame() {
        carList.setCarList();
        carList.setTrial();
    }

    private void runGame() {
        List<String> A = carList.getCarList();
        Integer B = carList.getTrial();
        System.out.println(A);
        System.out.println(B);
    }
}