package racingcar.view;


public class OutputView {

    // messages for input
    public void printCarNameMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printRoundTimeMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }


    // messages for output
    public void printResultMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printEachRoundResult() {

    }

    public void printWinner() {
        System.out.println("최종 우승자: ");
    }
}
