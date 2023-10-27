package racingcar.view;

import racingcar.model.Racer;

public class OutputView {

    public void printExecution() {
        System.out.println("실행 결과");
    }

    public void printResult(Racer racer) {
        System.out.println(racer.toString());
    }

    public void printFinalWinner(String winner) {
        System.out.println("최종 우승자 : " + winner);
    }
}
