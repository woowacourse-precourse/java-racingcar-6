package racingcar.domain.view.inputer;

import racingcar.domain.view.inputer.common.InputManager;
import racingcar.domain.entity.valueobject.Challenge;
import racingcar.domain.view.printer.IntermediateCoursePrinter;

public class ChallengeInputer {
    public static Challenge getChallenge() {
        IntermediateCoursePrinter.printChallenge();
        String userInput = InputManager.getInput();
        System.out.println();
        return new Challenge(userInput);
    }
}
