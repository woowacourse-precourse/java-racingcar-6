package racingcar.view;

import racingcar.constants.ViewConstant;
import java.util.List;

public class OutputView {
    public void printCarsNameInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printTotalRoundInputMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printResultGuideMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printMoveRecord(String carName, int moveRecord) {
        System.out.printf("%s : %s\n", carName, ViewConstant.ONE_MOVE_SYMBOL.repeat(moveRecord));
    }

    public void printRoundSeparator() {
        System.out.print(ViewConstant.ROUND_SEPARATOR);
    }

    public void printWinners(List<String> winnersName) {
        System.out.println("최종 우승자 : " + String.join(ViewConstant.WINNERS_SEPARATOR, winnersName));
    }
}
