package racingcar.view;

public class OutputView {

    public void printInputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printInputTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printRunResult() {
        System.out.println("\n" + "실행 결과");
    }

    public void printCurrentNameAndPosition(String currentCarNameAndPosition) {
        System.out.println(currentCarNameAndPosition + "\n");
    }

    public void printWinners(String winnerList) {
        System.out.println("최종 우승자 : " + winnerList);
    }
}
