package racingcar.view;

import java.util.List;

public class OutputView {


    private static final String INIT_GAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private static final String BEFORE_INPUT_GAME_COUNT = "시도할 회수는 몇회인가요?";
    private static final String NOTIFY_BEFORE_RESULT = "\n실행결과";

    private static final String FINAL_WINNER = "최종 우승자 : %s";


    private static OutputView instance;

    private OutputView() {
    }

    public static OutputView getInstance() {
        if (instance == null) {
            instance = new OutputView();
        }
        return instance;
    }

    public void printInitGame() {
        System.out.println(INIT_GAME);
    }

    public void printBeforeInputGameRound() {
        System.out.println(BEFORE_INPUT_GAME_COUNT);
    }

    public void printRoundResult(List<String> carResults) {
        for (String carResult : carResults) {
            System.out.println(carResult);
        }
        System.out.println();
    }

    public void notifyInitRoundResult() {
        System.out.println(NOTIFY_BEFORE_RESULT);
    }

    public void printWinners(String winners) {
        System.out.printf(FINAL_WINNER + "%n", winners);
    }
}
