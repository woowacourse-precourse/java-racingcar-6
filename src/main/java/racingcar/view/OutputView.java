package racingcar.view;

import racingcar.model.Car;

public class OutputView {
    public void printCarsName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printNumberOfAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printExecutionResults(Car car) {
        // TODO
        System.out.println();
    }
}
