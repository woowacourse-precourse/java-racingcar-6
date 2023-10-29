package racingcar;

import racingcar.racingCar.RacingCarGame;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AppConfig appConfig = new AppConfig();
        RacingCarGame racingCarGame = appConfig.racingCarGame();
        racingCarGame.playGame();
    }
}
