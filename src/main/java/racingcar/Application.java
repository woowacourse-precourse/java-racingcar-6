package racingcar;

import racingcar.service.RacingService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingService racingService = new RacingService();
        racingService.startRace();
    }
}
