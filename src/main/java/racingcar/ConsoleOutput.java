package racingcar;

import java.util.List;

public class ConsoleOutput {
    public void printCarNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printAttemptsInput() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printForward(List<String> cars, List<String> forward) {
        for (String car : cars) {
            System.out.println(car + " : " + forward.get(cars.indexOf(car)));
        }
    }

    public void printWinners(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }
}
