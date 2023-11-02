package racingcar.view;

import java.util.List;

public class Output {
    public void carNamesInputPrompt() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void attemptNumberInputPrompt() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void executionResultHeader() {
        System.out.println("\n실행 결과");
    }

    public void printMessage(final String message) {
        System.out.println(message);
    }

    public void printWinners(final List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
