package racingcar.game;

import racingcar.car.Car;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Car> carList;
    private int moveCnt;

    public Game() {
        this.carList = new ArrayList<>();
    }

    // 게임 시작
    public void start() {
        while (moveCnt > 0) {
            // 전진 조건 확인

            // 자동차 전진 or 멈춤
            moveCnt--;
        }
    }
}
