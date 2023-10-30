package racingcar.domain.inputer;

import racingcar.domain.inputer.common.InputManager;
import racingcar.domain.valueobject.ChallengeNumber;

public class ChallengeInputer {
    public static ChallengeNumber getChallengeNumber() {
        String userInput = InputManager.getInput();
        return new ChallengeNumber(userInput);
    }
}
