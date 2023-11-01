package racingcar;

import racingcar.controller.PlayRacingGame;

public class Application {


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AppConfig appConfig = new AppConfig();
        PlayRacingGame playRacingGame= appConfig.playRacingGame();
        playRacingGame.playRacingGame();
    }
}
