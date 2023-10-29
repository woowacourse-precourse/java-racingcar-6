package racingcar.view;

public class OutputView {

    public void printGameResultMessage() {
        System.out.println("\n실행 결과");
    }
    public void printGameLog(String car, String log) {
        System.out.println(car + " : " + log);
    }
    public void printWinner(String winners) {
        String message = String.format("최종 우승자 : %s", winners);
        System.out.println(message);
    }
}
