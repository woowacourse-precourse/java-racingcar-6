package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.service.RaceService;

public class OutputView {
    public static final String LOCATION_AND_NAME_DELIMITER = " : ";
    public static final String LOCATION = "-";
    public static final String NAME_DELIMITER = ", ";
    public static final String FINAL_WINNER = "최종 우승자";
    // TODO Service 분리
    private RaceService raceService = new RaceService();

    public void displayPerResults(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + LOCATION_AND_NAME_DELIMITER);
            for (int i = 0; i < car.getLocation(); i++) {
                System.out.print(LOCATION);
            }
            System.out.println();
            System.out.println();
        }
    }

    public void displayResults(List<Car> cars) {
        List<String> winnersNames = raceService.getWinner(cars).stream().map(Car::getName).collect(Collectors.toList());
        String winnerNamesMessage = String.join(NAME_DELIMITER, winnersNames);
        System.out.print(FINAL_WINNER + LOCATION_AND_NAME_DELIMITER + winnerNamesMessage);
    }
}
