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
}