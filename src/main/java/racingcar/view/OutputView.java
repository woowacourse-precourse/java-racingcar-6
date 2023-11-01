package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import racingcar.controller.Car;

public class OutputView {

    public static void printCars(List<Car> cars) {

        for (Car car : cars) {
            System.out.println(car.getName() + " : " + DrawHistogram.draw(car));
        }
        System.out.println();
    }

    public static void printWinners(List<Car> cars) {
        int maxLength = 0;
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getDistance() > maxLength) {
                maxLength = car.getDistance();
                winners.clear();
                winners.add(car.getName());
            } else if (car.getDistance() == maxLength) {
                winners.add(car.getName());
            }
        }

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}



