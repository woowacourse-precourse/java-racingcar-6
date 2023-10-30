package racingcar.domain.inputer;

import racingcar.domain.inputer.common.InputManager;
import racingcar.domain.valueobject.Challenge;

public class ChallengeInputer {
    public static Challenge getChallenge() {
        System.out.println("시도할 회수는 몇회인가요?");
        String userInput = InputManager.getInput();
        System.out.println();
        return new Challenge(userInput);
    }
}
