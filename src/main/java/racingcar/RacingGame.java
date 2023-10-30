package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final Referee referee = new Referee();
    private final InputHandler inputHandler = new InputHandler();

    public void run() {
        List<String> carNames = inputHandler.getValidCarNamesFromUser();
        List<Car> cars = Car.createCarsByNames(carNames);

        int attempts = inputHandler.getValidAttemptsFromUser();
        startRacing(cars, attempts);

        List<Car> winners = referee.getWinners(cars);
        printWinners(winners);
    }

    private void printWinners(List<Car> winners) {
        String result = "최종 우승자 : " + winners.stream().map(Car::getName).collect(Collectors.joining(" ,"));
        System.out.print(result);
    }


    private void startRacing(List<Car> cars, int attempts) {
        StringBuilder racingResult = new StringBuilder("\n실행 결과\n");
        while (attempts > 0) {
            for (Car car : cars) {
                car.moveForwardOrStop();
                racingResult
                        .append(car)
                        .append("\n");
            }
            racingResult.append("\n");
            attempts--;
        }
        System.out.print(racingResult.toString());
    }





}
