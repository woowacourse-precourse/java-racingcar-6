package racingcar.view;

public class ResultView {

    public void printHead() {
        System.out.println("실행결과");
    }

    void printPosition(int moveCount) {
        for (int i = 0; i <= moveCount; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }
}
