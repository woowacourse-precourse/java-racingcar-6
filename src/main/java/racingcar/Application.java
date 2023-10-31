package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        String carInput = Console.readLine();
        List<String> carNames = Arrays.stream(carInput.split(",")).toList();
        validateCarName(carNames);

        String attemptInput = Console.readLine();
        validateAttemptInput(attemptInput);

        List<Car> cars = carNames.stream().map(Car::new).toList();
        int attempt = Integer.parseInt(attemptInput);

    }

    private static void validateAttemptInput(String attempt) {
        try {
            int number = Integer.parseInt(attempt);
            if (number <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("올바른 시도 횟수를 입력해주세요.");
        }
    }

    public static void validateCarName(List<String> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }

        for (String carName : cars) {
            if (carName.isBlank() || carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.");
            }
        }
    }
}

class Car {

    private String name;
    private String progress;

    public Car(String name) {
        this.name = name;
        this.progress = "";
    }

    public void execute(int threshold, int number) {
        if (number >= threshold) {
            moveForward();
        }
    }

    private void moveForward() {
        progress += "-";
    }

    public void showProgress() {
        System.out.printf("%s : %s%n", this.name, this.progress);
    }

    public String getName() {
        return name;
    }

    public String getProgress() {
        return progress;
    }
}
