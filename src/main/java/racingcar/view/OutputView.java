package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;

public class OutputView {


    public static void printCurrentSituation(List<Car> cars) {
        System.out.println("실행 결과");
        for (Car car : cars) {
            String position = getPosition(car);
            System.out.println(car.getName() + " : " + position);
        }
        System.out.println();
    }

    private static String getPosition(Car car) {
        return "-".repeat(car.getPosition());
    }

    public static void printWinner(List<Car> winners) {
        String winnersName = getWinnersName(winners);
        System.out.print("최종 우승자 : " + winnersName);
    }

    private static String getWinnersName(List<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
