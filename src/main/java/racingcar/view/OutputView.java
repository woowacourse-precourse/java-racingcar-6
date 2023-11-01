package racingcar.view;

public class OutputView {
    static final String RESULT = "실행 결과";
    static final String WINNER = "최종 우승자 : ";

    public static void displayResult(){
        System.out.println(RESULT);
    }

    public static void displayEachRoundResult(String result) {
        System.out.println(result);
    }

    public static void displayWinner() {
        System.out.print(WINNER);
    }

    public static void displayGetWinner(String winner) {
        System.out.println(winner);
    }
}
