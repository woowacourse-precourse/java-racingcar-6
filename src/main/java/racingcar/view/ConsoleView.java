package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class ConsoleView {
    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printCurrentPositions(List<Car> cars) {
        StringBuilder output = new StringBuilder();
        for (Car car : cars) {
            StringBuilder position = new StringBuilder();
            for (int i = 0; i < car.getDistance(); i++) {
                position.append("-");
            }
            output.append(car.getName()).append(" : ").append(position).append("\n");
        }
        printMessage(output.toString());
    }

    public void printWinners(List<Car> winners) {
        List<String> winnerNames = winners.stream().map(Car::getName).toList();
        String result = String.join(", ", winnerNames);
        printMessage("최종 우승자 : " + result);
    }
}