package racingcar.view;

import racingcar.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputRaceView {
    public static void printRaceResult(List<Car> cars) {
        System.out.println("\n실행 결과");
        cars.forEach(car -> {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        });
    }

    public static void printWinners(List<Car> winners) {
        System.out.println("최종 우승자 : " + winners.stream().map(Car::getName).collect(Collectors.joining(", ")));
    }
}
