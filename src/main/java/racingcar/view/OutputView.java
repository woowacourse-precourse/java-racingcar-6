package racingcar.view;

public class OutputView {

    public static final String FINAL_WINNER = "최종 우승자";

    public void finalWinner(String winner) {
        System.out.println(FINAL_WINNER + " " + ":" + " " + winner);
    }
}
