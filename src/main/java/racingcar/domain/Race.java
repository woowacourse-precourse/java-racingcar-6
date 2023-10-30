package racingcar.domain;

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

    }

    private List<Car> getCarNames() {

    }

    private int getMoveCount() {

    }
}
