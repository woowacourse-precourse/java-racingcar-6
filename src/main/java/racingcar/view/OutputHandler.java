package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputHandler {

    public static void printRaceState(List<Car> cars) {
        cars.forEach(car -> System.out.println(generateSingleCarState(car)));
        System.out.println();
    }

    private static String generateSingleCarState(Car car) {
        StringBuilder state = new StringBuilder(car.getName()).append(" : ");
        for (int i = 0; i < car.getPosition(); i++) {
            state.append("-");
        }
        return state.toString();
    }

    public static void printWinners(List<Car> winners) {
        String winnerNames = String.join(", ", winners.stream().map(Car::getName).toArray(String[]::new));
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
