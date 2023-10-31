package racingcar.view;

public class GameOutputView {

    public void printResult() {
        System.out.println("실행 결과");
    }

    public void printScore(String name, int position) {
       System.out.println(name + " : " + "-".repeat(position));
    }

    public void printOneLine() {
        System.out.println();
    }
}
