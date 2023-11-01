package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.Car;
import racingcar.utils.GameMessage;
import racingcar.utils.Util;

public class OutputView {

    public void printStartMessage() {
        System.out.println(GameMessage.RUN_RESULTS_MESSAGE);
    }

    public void printCars(List<Car> participatingCars) {
        String carsOutput = buildCarsOutput(participatingCars);
        printOutput(carsOutput);
    }

    private String buildCarsOutput(List<Car> participatingCars) {
        StringBuilder builder = new StringBuilder();
        for (Car car : participatingCars) {
            builder.append(formatCarOutput(car));
        }
        return builder.toString();
    }


    private String formatCarOutput(Car car) {
        StringBuilder builder = new StringBuilder();
        builder.append(car.getName()).append(" : ");
        builder.append(getCarMovement(car.getLocation())).append(System.lineSeparator());
        return builder.toString();
    }

    private void printOutput(String output) {
        System.out.println(output);
    }

    private String getCarMovement(int location) {
        return Util.CAR_MOVEMENT_SYMBOL.repeat(Math.max(0, location));
    }

    public void printWinners(List<String> winners) {
        String winnersName = joinWinners(winners);
        declareWinners(winnersName);
    }

    private String joinWinners(List<String> winners) {
        return winners.stream()
                .collect(Collectors.joining(Util.COMMA_AND_SPACE));
    }

    private void declareWinners(String winnersName) {
        System.out.printf(GameMessage.FINAL_WINNER_MESSAGE, winnersName);
    }
}
