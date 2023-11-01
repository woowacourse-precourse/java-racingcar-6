package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    public void printMoveResult(List<Car> cars, Integer attempts) {
        System.out.println("실행 결과");
        for (int i = 0; i < attempts; i++) {
            for (Car car : cars) {
                System.out.println(car.getName() + " : " + "-".repeat(car.getMoves()));
            }
            System.out.println();
        }
    }

    public void printWinners(List<Car> winners) {
        String phrase = "최종 우승자 : ";
        for (Car winner : winners) {
            phrase += winner.getName() + ", ";
        }
        phrase = phrase.substring(phrase.length() - 2);
        System.out.println(phrase);
    }
}
