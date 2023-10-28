package racingcar.view;

import racingcar.util.RacingGuideMessage;

public class OutputView {

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showMessage(RacingGuideMessage racingGuideMessage) {
        System.out.println(racingGuideMessage.getMessage());
    }
}
