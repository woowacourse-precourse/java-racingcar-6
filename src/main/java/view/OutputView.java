package view;

import java.util.List;
import java.util.StringJoiner;
import racingcar.Car;

public class OutputView {

    private OutputView() {
    }

    public static void printResult() {
        System.out.println();
        System.out.println("실행결과");
    }

    public static void printCarInfo(Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printWinner(List<Car> winnerCars) {
        StringJoiner joiner = new StringJoiner(", ");
        for (Car car : winnerCars) {
            joiner.add(car.getName());
        }
        System.out.println("최종 우승자 : " + joiner);
    }
}
