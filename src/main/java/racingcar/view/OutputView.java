package racingcar.view;

public class OutputView {
    public void executionResult() {
        System.out.println("실행 결과");
    }

    public void showResult(String result) {
        System.out.println(result);
    }

    public void showWinner(String totalResult) {
        System.out.println("최종 우승자 : " + totalResult);
    }
}
