package racingcar;

import racingcar.controller.RaceGameController;

public class Application {
    public static void main(String[] args) {
        // 자동차 경주 게임 시작
        RaceGameController raceGameController = new RaceGameController();
        raceGameController.start();
    }
}
