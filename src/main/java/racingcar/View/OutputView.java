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

    public void printRandomCount(int underBar) {
        for(int i = 0 ; i < underBar ; i++){
            System.out.print("-");
        }
        System.out.println();
    }
}
