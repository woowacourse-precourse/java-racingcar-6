package racingcar.view;

public class OutputView {

    public void printAskingForCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printAskingForNumberOfRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printResult() {
        System.out.println("실행 결과");
    }

    private void printEachResult() {

    }

    public void printWinners() {
        System.out.println("최종 우승자 : ");
    }

}
