package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.Car;
import racingcar.utils.Constants;
import racingcar.utils.GameMessage;

public class OutputView {

    public void printStartMessage() {
        System.out.println(GameMessage.RUN_RESULTS_MESSAGE);
    }

    public void printCars(List<Car> participatingCars) {
        String carsOutput = buildCarsOutput(participatingCars);
        printOutput(carsOutput);
    }

    private String buildCarsOutput(List<Car> participatingCars) {
        return participatingCars.stream()
                .map(this::formatCarOutput)
                .collect(Collectors.joining());
    }

    private String formatCarOutput(Car car) {
        return String.format(Constants.CAR_NAME_AND_POSITION_FORMAT, car.getName(),
                getCarMovement(car.getLocation()));
    }

    private void printOutput(String output) {
        System.out.println(output);
    }

    private String getCarMovement(int location) {
        return Constants.CAR_MOVEMENT_SYMBOL.repeat(Math.max(0, location));
    }

    public void printWinners(List<String> winners) {
        String winnersName = joinWinners(winners);
        declareWinners(winnersName);
    }

    private String joinWinners(List<String> winners) {
        return winners.stream()
                .collect(Collectors.joining(Constants.COMMA_AND_SPACE));
    }

    private void declareWinners(String winnersName) {
        System.out.printf(GameMessage.FINAL_WINNER_MESSAGE, winnersName);
    }
}
