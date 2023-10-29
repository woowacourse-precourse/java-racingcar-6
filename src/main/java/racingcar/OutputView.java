package racingcar;

public class OutputView {
    public static final String PLAY_RESULT_MESSAGE = "실행결과";
    public static final String CAR_FORWARD_FLAG = "-";
    public static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";

    public static void printPlayResult() {
        System.out.println(PLAY_RESULT_MESSAGE);
    }

    public static void printFinalWinner() {
        System.out.println(FINAL_WINNER_MESSAGE);
    }
}
