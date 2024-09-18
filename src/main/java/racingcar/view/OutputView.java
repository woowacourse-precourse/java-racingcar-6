package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    public void executionResultMessage() {
        System.out.println("\n실행 결과");
    }

    public void finalWinnerMessage(String cars) {
        System.out.print("최종 우승자 : " + cars);
    }

    public void printMoveResults(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }
}
