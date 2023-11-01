package racingcar;

import racingcar.domain.StartCondition;
import racingcar.domain.JudgeMovement;
import racingcar.domain.Result;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        StartCondition startCondition = new StartCondition();
        String[] carNames = startCondition.inputCarName();
    }
}
