package racingcar.ui;

import racingcar.Car;

import java.util.List;

public class OutputView {
    public void displayStartMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void displayGetMoveCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void displayRaceMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void displayRaceStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getStatus());
        }
        System.out.println();
    }

    public void displayWinner(List<String> winner) {
        System.out.println("최종 우승자 : " + String.join(", ", winner));
    }
}