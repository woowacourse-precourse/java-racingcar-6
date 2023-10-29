package racingcar.view;

public class OutputView {
    public void display(String string) {
        System.out.println(string);
    }

    public void startDisplayResult() {
        System.out.println("\n실행결과");
    }

    public void displayWinners(String winners) {
        System.out.printf("최종 우승자 : %s\n", winners);
    }

}
