package racingcar.service;

import java.util.List;
import racingcar.model.CarList;

public class GameService {
    CarList carList = new CarList();

    public void runGame() {
        List<String> A = carList.setCarList();
        System.out.println(A);
    }
}