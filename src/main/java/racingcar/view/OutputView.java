package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String RESULT_GUIDE_MESSAGE = "\n실행 결과";
    private static final String ONE_MOVE_SYMBOL = "-";
    private static final String ROUND_SEPARATOR = "\n";
    private static final String WINNERS_SEPARATOR = ", ";
    public void printResultGuideMessage() {
        System.out.println(RESULT_GUIDE_MESSAGE);
    }

    public void printMoveRecord(String carName, int moveRecord) {
        System.out.printf("%s : %s\n",carName, ONE_MOVE_SYMBOL.repeat(moveRecord));
    }

    public void printRoundSeparator() {
        System.out.print(ROUND_SEPARATOR);
    }

    public void printWinners(List<String> winnersName) {
        System.out.println("최종 우승자 : " + String.join(WINNERS_SEPARATOR,winnersName));
    }
}
