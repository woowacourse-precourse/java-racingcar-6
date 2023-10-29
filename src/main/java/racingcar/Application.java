package racingcar;

import camp.nextstep.edu.missionutils.*;
import racingcar.domain.Race;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
//        String[] carNames = inputView.getCarNames();
        int AttemptCount = inputView.getAttemptCount();
    }
}
