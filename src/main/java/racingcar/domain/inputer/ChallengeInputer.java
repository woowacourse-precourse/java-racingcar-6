package racingcar.domain.inputer;

import racingcar.domain.inputer.common.InputManager;
import racingcar.domain.valueobject.Challenge;

public class ChallengeInputer {
    public static Challenge getChallenge() {
        String userInput = InputManager.getInput();
        return new Challenge(userInput);
    }
}
