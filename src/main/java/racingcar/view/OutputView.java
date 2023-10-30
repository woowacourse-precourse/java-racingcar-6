package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Race;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static boolean isFirstTime = true;

    public static void printResult(Race race) {
        if (isFirstTime) {
            System.out.println("실행 결과");
            isFirstTime = false;
        }
        for (Car car : race.getCars()) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        System.out.print("최종 우승자 : ");
        System.out.println(winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", ")));
    }
}
