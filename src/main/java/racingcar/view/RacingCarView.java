package racingcar.view;

import racingcar.model.Message;

public class RacingCarView {

    private static RacingCarView instance;

    private RacingCarView() {
    }

    public static RacingCarView getInstance() {
        if (instance == null) {
            instance = new RacingCarView();
        }

        return instance;
    }

    public void printInputCarNameMessage() {
        System.out.println(Message.CARS_NAME_PROMPT);
    }
}
