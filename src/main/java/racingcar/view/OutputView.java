package racingcar.view;

import java.util.List;

public class OutputView {

    private static final String DISTANCE_STRING_VALUE = "-";
    private static final String BLANK_LINE = "";

    public void printInputCarNameMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printInputNumberMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printExecutionResultMessage() {
        printBlankLine();
        System.out.println("실행 결과");
    }

    public void printRoundResult(String carName, int distance) {
        System.out.printf("%s : %s\n", carName, DISTANCE_STRING_VALUE.repeat(distance));
    }

    public void printBlankLine() {
        System.out.println(BLANK_LINE);
    }

    public void printWinners(List<String> winnersName) {
        System.out.print("최종 우승자 : ");
        System.out.print(winnersName.get(0));

        for (int index = 1; index < winnersName.size(); index++) {
            System.out.print(", ");
            System.out.print(winnersName.get(index));
        }
    }
}
