package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private int moveCount;
    private List<Car> carList;
    private List<Car> winnerList;


    public Race() {
        init();
    }

    private void init() {
        carList = getCarNames();
        moveCount = getMoveCount();
    }

    public void start() {
        while(moveCount != 0) {
            carList.forEach(car -> car.move());
            moveCount--;
        }

        checkWinner();
    }

    private void checkWinner() {
        int maxPosition = 0;
        winnerList = new ArrayList<Car>();

        for(Car car : carList) {
            if (car.getPostion() == maxPosition) {
                winnerList.add(car);
            } else if(car.getPostion() > maxPosition) {
                maxPosition = car.getPostion();

                winnerList.clear();
                winnerList.add(car);
            }
        }

        showWinner();
    }

    private List<Car> getCarNames() {

    }

    private int getMoveCount() {

    }

    private void showWinner() {

    }
}
