package racingcar.view.Output;

public class OutputView {
    private final String RACE_REULT= "실행 결과";
    private final String FINAL_WINNER = "최종 우승자 : ";

    // 결과 출력
    public void printResult() {
        System.out.println(RACE_REULT);
    }

    // 최종 우승자 출력
    public void printWinner(String winner) {
        System.out.println(String.format("%s%s",FINAL_WINNER ,winner));
    }

}
