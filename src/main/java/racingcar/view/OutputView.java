package racingcar.view;

import java.util.List;

public class OutputView {
    protected static void printNameHelp() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    protected static void printTurnHelp() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printTurnResult(String carName, int progress) {
        System.out.print(carName + " : ");
        for (int moved = 0; moved < progress; moved++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printWinner(List<String> winners) {
        String str = String.join(", ", winners);
        System.out.println("최종 우승자 : " + str);
    }
}
