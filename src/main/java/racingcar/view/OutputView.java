package racingcar.view;

public class OutputView {
    public void lineBreak () {
        System.out.println();
    }

    public void result() {
        System.out.println("\n실행 결과");
    }
    public void resultByRound(String name, String printDistance) {
        System.out.printf("%s : %s\n", name, printDistance);
    }
}
