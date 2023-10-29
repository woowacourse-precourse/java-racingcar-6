package racingcar.view;

public class ConsoleOutputView implements OutputView{
    private static final String REQUEST_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분";
    private static final String REQUEST_GAME_ROUND_MESSAGE = "시도할 회수는 몇회인가요?";
    private static ConsoleOutputView instance;

    private ConsoleOutputView() {}

    public static ConsoleOutputView getInstance() {
        if (instance == null) {
            instance = new ConsoleOutputView();
        }
        return instance;
    }

    @Override
    public void printRequestCarNames() {
        System.out.println(REQUEST_CAR_NAMES_MESSAGE);
    }

    @Override
    public void printRequestGameRound() {
        System.out.println(REQUEST_GAME_ROUND_MESSAGE);
    }

    @Override
    public void printRoundResult() {

    }

    @Override
    public void printGameWinner() {

    }
}
