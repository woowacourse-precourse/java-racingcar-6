package racingcar.view;

import racingcar.constant.RacingMessage;

public class OutputView {
    private static OutputView instance;

    private OutputView() {}

    public static OutputView getInstance() {
        if(instance == null) {
            instance = new OutputView();
        }
        return instance;
    }

    public void printRacingResult() {
        System.out.println(RacingMessage.GAME_RESULT_MESSAGE.getMessage());
    }

    public void printCarRacingStatus(String racingResult) {
        System.out.println(racingResult);
    }

    public void printWinner(String racingWinner) {
        System.out.println(RacingMessage.WINNER_MESSAGE.getMessage() + racingWinner);
    }

}
