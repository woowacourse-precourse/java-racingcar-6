package racingcar.view;

public class OutputView {

    public void initial() {
        System.out.println("\n실행 결과");
    }

    public void result(String name, String bar) {
        System.out.println(name + " : " + bar);
    }

    public void winner(String winnerName) {
        System.out.println("최종 우승자 : " + winnerName);
    }
}
