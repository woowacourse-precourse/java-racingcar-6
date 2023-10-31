package racingcar.game;

import racingcar.car.Car;
import racingcar.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Car> carList;
    private Player player;
    private int moveCnt;

    public Game() {
        this.carList = new ArrayList<>();
        this.player = new Player();
    }

    // 게임 시작
    public void start() {
        // 이동 횟수 입력
        moveCnt = player.inputMoveCnt();

        while (moveCnt > 0) {
            // 전진 조건 확인

            // 자동차 전진 or 멈춤
            moveCnt--;
        }
    }
}
