package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final static String WINNERS_MESSAGE_FORMAT = "최종 우승자 : %s";

    private final Referee referee = new Referee();
    private final InputHandler inputHandler = new InputHandler();

    public void launch() {
        List<String> carNames = inputHandler.getValidCarNamesFromUser();
        List<Car> cars = Car.createCarsByNames(carNames);

        int attempts = inputHandler.getValidAttemptsFromUser();
        runRacingAndPrintResults(cars, attempts);

        List<Car> winners = referee.getWinners(cars);
        printWinners(winners);
    }

    private void runRacingAndPrintResults(List<Car> cars, int attempts) {
        StringBuilder results = new StringBuilder("\n실행 결과\n");
        for (int i = 0; i < attempts; i++) {
            results.append(getOneRoundResult(cars))
                    .append("\n");
        }
        printResults(results);
    }

    private String getOneRoundResult(List<Car> cars) {
        return cars.stream()
                .map((car) -> {
                    car.moveForwardOrStop();
                    return car.getStatus();
                })
                .collect(Collectors.joining("\n"));
    }

    private void printResults(StringBuilder results) {
        System.out.print(results);
    }

    private void printWinners(List<Car> winners) {
        String winnerNames = getWinnerNames(winners);

        String message = String.format(WINNERS_MESSAGE_FORMAT, winnerNames);
        System.out.print(message);
    }

    private String getWinnerNames(List<Car> winners) {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(" ,"));
    }
}
