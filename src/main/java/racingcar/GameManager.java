package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameManager {
    User user = new User();
    public void start() {
        List<String> carNames = user.setCar();
        List<Car> carList = listOfCars(carNames);
        int cnt = user.setMoves();

        System.out.println("실행 결과");

        for (int i = 0; i < cnt; i++) {
            List<Integer> randomNumbers = RandomNumberGenerator.generateRandomNumber(carList.size());
            move(carList, randomNumbers);
            user.listOfResult(carList);
        }
    }

    public List<Car> listOfCars(List<String> carNames) {

    }

    public void move(List<Car> carList, List<Integer> randomNumbers) {

    }
}
