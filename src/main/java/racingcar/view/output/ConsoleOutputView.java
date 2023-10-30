package racingcar.view.output;

import java.util.List;

public class ConsoleOutputView implements Outputview {

    private static final String POSITION_MARK = "-";
    private static final String WINNER_JOINER = ", ";

    @Override
    public void askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Override
    public void askPlayCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    @Override
    public void printResult() {
        System.out.println();
        System.out.println("실행 결과");
    }

    @Override
    public void printEachCarStatus(final String name, final int position) {
        System.out.println(name + " : " + POSITION_MARK.repeat(position));
    }

    @Override
    public void printBlankLine() {
        System.out.println();
    }

    @Override
    public void printWinners(final List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(WINNER_JOINER, winners));
    }
}
