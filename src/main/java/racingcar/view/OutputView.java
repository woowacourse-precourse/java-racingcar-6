package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public final class OutputView {
    public static final String LOCATION = "-";
    public static final String LOCATION_AND_NAME_DELIMITER = " : ";
    public static final String NAME_DELIMITER = ", ";
    public static final String FINAL_WINNER = "최종 우승자";

    public static void displayPerRace(List<Car> cars) {
        for (Car car : cars) {
            displayCurrentCar(car);
        }
        System.out.println();
    }

    private static void displayCurrentCar(Car car) {
        String result = car.getName() + LOCATION_AND_NAME_DELIMITER;
        for (int i = 0; i < car.getLocation(); i++) {
            result += LOCATION;
        }
        System.out.println(result);
    }

    public static void displayResults(List<Car> cars) {
        List<String> winnersNames = cars.stream().map(Car::getName).toList();
        String winnerNamesMessage = String.join(NAME_DELIMITER, winnersNames);
        System.out.print(FINAL_WINNER + LOCATION_AND_NAME_DELIMITER + winnerNamesMessage);
    }

    public static void displayStartRace() {
        System.out.println();
        System.out.println("실행 결과");
    }
}
