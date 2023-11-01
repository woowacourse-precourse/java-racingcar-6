package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    public static void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printRaceResult(List<Car> cars) {
        cars.forEach(System.out::println);
        System.out.println();
    }

    public static void printWiningResult(List<Car> winingCars) {
        List<String> winingCarsName = winingCars.stream()
                .map(Car::getName)
                .toList();
        String winingResult = String.join(", ", winingCarsName);
        System.out.println("최종 우승자 : " + winingResult);
    }
}
