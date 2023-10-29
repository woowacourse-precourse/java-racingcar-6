package racingcar.view;

public class OutputView {
    private static final String GAME_RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static OutputView instance;

    private OutputView() {}

    public static OutputView getInstance() {
        if(instance == null) {
            instance = new OutputView();
        }
        return instance;
    }

    public void printRacingResult() {
        System.out.println(GAME_RESULT_MESSAGE);
    }

    public void printCarRacingStatus(String racingResult) {
        System.out.println(racingResult);
    }

    public void printWinner(String racingWinner) {
        System.out.println(WINNER_MESSAGE + racingWinner);
    }

}
