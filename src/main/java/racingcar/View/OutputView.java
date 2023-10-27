package racingcar.View;

public class OutputView {
    private static final String runResultMsg = "실행결과";
    private static final String whoIsWinner = "최종 우승자 : ";

    public void printResultMsg() {
        System.out.println(runResultMsg);
    }

    public void printWinnerName() {
        System.out.println(whoIsWinner);
    }

    public void printRandomCount(String underBar) {
        System.out.println(underBar);
    }
}
