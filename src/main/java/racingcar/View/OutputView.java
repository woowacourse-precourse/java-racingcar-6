package racingcar.View;

public class OutputView {
    private static final String RUN_RESULT_MSG = "실행결과";
    private static final String WHO_IS_WINNER = "최종 우승자 : ";

    public void printResultMsg() {
        System.out.println(RUN_RESULT_MSG);
    }

    public void printWinnerName() {
        System.out.print(WHO_IS_WINNER);
    }

    public String printRandomCount(int underBar) {
        String underbar = "";
        for (int i = 0; i < underBar; i++) {
            underbar += "-";
        }
        return underbar;

    }
}
