package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.service.RaceService;

public class OutputView {
    private RaceService raceService = new RaceService();

    public void displayPerResults(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getLocation(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public void displayResults(List<Car> cars) {
        List<String> winnersNames = raceService.getWinner(cars).stream().map(Car::getName).collect(Collectors.toList());
        String winnerNamesMessage = String.join(", ", winnersNames);
        System.out.print("최종 우승자 : " + winnerNamesMessage);
    }
}
