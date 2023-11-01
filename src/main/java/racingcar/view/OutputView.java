package racingcar.view;

public class OutputView {

    public OutputView() {
    }

    public void displayExecutionResultsStartView() {
        System.out.println("실행 결과");
    }

    public void displayExecutionResultsView(String cars) {
        System.out.println(cars);
    }

    public void displayWinnerView(String winners) {
        System.out.println(String.format("최종 우승자 : %s", winners));
    }

}
