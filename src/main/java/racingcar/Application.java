package racingcar;

import racingcar.configuration.AppConfig;
import racingcar.configuration.Config;
import racingcar.controller.RacingGameController;

public class Application {
    public static void main(String[] args) {
        Config config = generateConfig();
        RacingGameController racingGameController = generateRacingController(config);

        racingGameController.playGame();
    }

    private static Config generateConfig() {
        return AppConfig.getInstance();
    }

    private static RacingGameController generateRacingController(Config config) {
        return config.racingController();
    }
}

/*

TODO:
 final 넣어야할곳 찾아서 다 넣기
 MemoryRepository 쓸떄도 <>써줘야하나?
 테스트코드에서 중복내용 줄이기
 */