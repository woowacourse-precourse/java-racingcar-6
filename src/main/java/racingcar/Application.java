package racingcar;

import racingcar.domain.Racing;
import racingcar.domain.RacingInfo;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingInfo racinginfo = RacingInfo.enter();
        Racing racing = Racing.create(racinginfo);
        racing.start();
    }
}
