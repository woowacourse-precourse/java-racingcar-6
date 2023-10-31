package racingcar.view;

public class InplayView {
    public void printNotice() {
        System.out.println("실행 결과");
    }

    public void printProgress(String name, StringBuilder distance) {
        System.out.println(name + " : " + distance);
    }

    public void printWinner(String winner) {
        System.out.println("최종 우승자 : " + winner);
    }
}
