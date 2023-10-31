package racingcar.view;

public class GameView {

    private static GameView INSTANCE;

    private final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";
    private final String TRIES_INPUT_MESSAGE = "시도할 회수는 몇회인가요?\n";
    private final String RESULT_MESSAGE = "\n실행 결과\n";
    private final String WINNER_MESSAGE = "최종 우승자 : ";

    private GameView() {
    }

    public static GameView getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GameView();
        }

        return INSTANCE;
    }

    public void printWinners(final String winners) {
        System.out.print(WINNER_MESSAGE);
        System.out.print(winners);
    }

    public void printCarInputMessage() {
        System.out.print(CAR_NAME_INPUT_MESSAGE);
    }

    public void printTryInputMessage() {
        System.out.print(TRIES_INPUT_MESSAGE);
    }

    public void printResultMessage(String gameResult) {
        System.out.print(RESULT_MESSAGE);
        System.out.print(gameResult);
    }
}
