package view;

import domain.Car;

import java.util.List;

public class OutputView {
    public static void printHeadResult() {
        System.out.print("\n실행 결과\n");
    }

    public static void printWinner(String winner) {
        System.out.print(String.format("최종 우승자 : %s", winner));
    }
    public static void printOneRoundResult(List<Car> cars) {
        cars.forEach(car -> System.out.println(car.toString()));
        System.out.println();
    }
}
