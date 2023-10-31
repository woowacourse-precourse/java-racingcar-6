package racingcar;

import racingcar.config.AppConfig;
import racingcar.domain.RaceGame;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RaceGame raceGame = RaceGame.builder()
                .inputHandler(AppConfig.inputHandler())
                .carRegistration(AppConfig.carRegistration())
                .billboard(AppConfig.billboard())
                .gasolineProvider(AppConfig.gasolineProvider())
                .build();
        raceGame.play();
    }
}
