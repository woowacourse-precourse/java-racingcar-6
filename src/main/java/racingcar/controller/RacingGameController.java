package racingcar.controller;

import static racingcar.view.InputView.inputAttemptCount;
import static racingcar.view.InputView.inputCarNames;

import racingcar.domain.Race;

/**
 * <p>자동차 경주 게임의 메인 컨트롤러 클래스입니다.</p>
 * <p>사용자로부터 자동차 이름과 시도 횟수를 입력 받아 경주를 실행합니다.</p>
 */
public class RacingGameController {

    /**
     * <p>자동차 경주 게임을 실행하는 메소드입니다.</p>
     * <p>사용자로부터 자동차 이름과 시도 횟수를 입력 받아 {@link Race} 객체를 생성하고 경주를 시작합니다.</p>
     */
    public void run() {
        Race race = new Race(inputCarNames(), inputAttemptCount());
        race.startRace();
    }
}
