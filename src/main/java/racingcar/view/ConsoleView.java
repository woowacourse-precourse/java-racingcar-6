package racingcar.view;

import racingcar.model.Car;

import java.util.List;
import racingcar.util.ConsoleWrapper;

public class ConsoleView {
    private final ConsoleWrapper consoleWrapper;

    public ConsoleView(ConsoleWrapper consoleWrapper) {
        this.consoleWrapper = consoleWrapper;
    }

    public List<String> getInputCarNames() {
        printMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNamesArray = consoleWrapper.readLine().split(",");
        return List.of(carNamesArray);
    }

    public int readValidNumberOfAttempts() {
        String input = readInput();
        validateNumberOfAttempts(input);
        printEmptyLine();
        return Integer.parseInt(input);
    }

    private String readInput() {
        printMessage("시도할 회수는 몇회인가요?");
        return consoleWrapper.readLine();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
    public void printEmptyLine() {
        System.out.println();
    }

    public void printCurrentPositions(List<Car> cars) {
        StringBuilder output = new StringBuilder();
        for (Car car : cars) {
            String position = "-".repeat(Math.max(0, car.getDistance()));
            output.append(car.getName()).append(" : ").append(position).append("\n");
        }
        printMessage(output.toString());
    }

    public void printWinners(List<Car> winners) {
        List<String> winnerNames = winners.stream().map(Car::getName).toList();
        String result = String.join(", ", winnerNames);
        printMessage("최종 우승자 : " + result);
    }

    private void validateNumberOfAttempts(String input) {
        if (!input.matches("\\d+") || Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException("정수를 입력해주세요.");
        }
    }
}