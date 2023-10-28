package racingcar.view;

import racingcar.controller.ViewController;
import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    public static void showCarNameAndPosition(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + ViewController.resultPosition(car));
        }
        System.out.println("\n");
    }

    public static void finalWinnerMessage() {
        System.out.println("최종 우승자 :");
    }
}
