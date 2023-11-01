package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class ViewRacingGame {
    public void printCarStatus(Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
    }

    public void printWinners(List<String> winners) {
        if (winners.size() == 1) {
            System.out.println("최종 우승자 : " + winners.get(0));
        } else {
            System.out.println("최종 우승자 : " + String.join(", ", winners));
        }
    }
}
