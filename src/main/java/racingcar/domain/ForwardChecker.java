package racingcar.domain;

import racingcar.constants.GameOption;

public class ForwardChecker {
    public Boolean checkIfForward(int number) {
        return number >= GameOption.FORWARD_THRESHOLD;
    }
}
