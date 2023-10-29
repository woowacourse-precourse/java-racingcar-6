package racingcar.view;

public class OutputViewImpl implements OutputView {

    @Override
    public void printExecution() {
        System.out.println("\n실행 결과");
    }

    @Override
    public void printResult(String result) {
        System.out.println(result);
    }

    @Override
    public void printFinalWinner(String winner) {
        System.out.print("최종 우승자 : " + winner);
    }
}
