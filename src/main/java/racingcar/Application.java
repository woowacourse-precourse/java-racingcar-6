package racingcar;

import racingcar.controller.RacingGameController;

/**
 * <p>자동차 경주 게임의 시작점 클래스입니다.</p>
 *
 * <p>이 클래스의 {@link #main(String[])} 메서드를 실행하여 자동차 경주 게임을 시작할 수 있습니다.</p>
 */
public class Application {

    /**
     * <p>자동차 경주 게임의 시작점입니다.</p>
     *
     * <p>이 메서드를 실행하여 자동차 경주 게임을 시작합니다. 게임의 진행은 {@link RacingGameController} 클래스를 통해 제어됩니다.</p>
     *
     * @param args 커맨드 라인 인수. 사용되지 않습니다.
     */
    public static void main(String[] args) {
        RacingGameController racingGameController = new RacingGameController();
        racingGameController.run();
    }
}
