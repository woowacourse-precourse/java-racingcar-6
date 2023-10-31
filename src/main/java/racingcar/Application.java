package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String carInput = Console.readLine();
        List<String> carNames = Arrays.stream(carInput.split(",")).toList();
        validateCarName(carNames);

        System.out.println("시도할 회수는 몇회인가요?");
        String attemptInput = Console.readLine();
        validateAttemptInput(attemptInput);

        List<Car> cars = carNames.stream().map(Car::new).toList();
        int attempt = Integer.parseInt(attemptInput);

        final int threshold = 4;

        System.out.println("실행 결과");
        while (attempt-- >= 0) {
            for (Car car : cars) {
                int randomNumber = generateRandomNumber();
                car.execute(threshold, randomNumber);
            }

            for (Car car : cars) {
                car.showProgress();
            }

            System.out.println();
        }

        int maxForwardCount = -1;
        for (Car car : cars) {
            int forwardCount = car.getProgress().length();
            if (forwardCount > maxForwardCount) {
                maxForwardCount = forwardCount;
            }
        }

        StringBuilder result = new StringBuilder();
        for (Car car : cars) {
            int forwardCount = car.getProgress().length();
            if (forwardCount == maxForwardCount) {
                if (!result.isEmpty()) {
                    result.append(", ");
                }
                result.append(car.getName());
            }
        }

        System.out.printf("최종 우승자 : %s", result);
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

    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
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
