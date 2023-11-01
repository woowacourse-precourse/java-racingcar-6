package racingcar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Set;


public class Application {
    public static void main(String[] args) {
        List<Car> cars = inputCarNames();
        int numAttempts = getNumAttempts();

        for (int attempt = 0; attempt < numAttempts; attempt++) {
            for (Car car : cars) {
                car.moveForwardOrStop();
                car.displayNameWithDash();
            }
            System.out.println("");
        }

        List<String> winners = determineWinners(cars);
        System.out.print("최종 우승자 : " + String.join(", ", winners));
    }

    static List<Car> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            try {
                validateCarNameFromEmpty(carName);
                validateCarNameFromLength(carName);
                cars.add(new Car(carName.trim()));
            } catch (IllegalArgumentException e) {
                System.out.println("유효하지 않은 자동차 이름입니다. 프로그램을 종료합니다.");
                System.exit(1);
            }
        }

        validateCarNameFromDuplicate(cars);

        return cars;
    }

    static void validateCarNameFromEmpty(String carName) {
        if (carName.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
    }
    private static void validateCarNameFromLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }
    private static void validateCarNameFromDuplicate(List<Car> cars) {
        Set<String> uniqueCarNames = new HashSet<>();
        for (Car car : cars) {
            String carName = car.getName();
            if (uniqueCarNames.contains(carName)) {
                throw new IllegalArgumentException("중복된 자동차 이름입니다.");
            }
            uniqueCarNames.add(carName);
        }
    }

    private static int getNumAttempts() {
        while (true) {
            System.out.println("시도 할 횟수를 입력하세요.");
            String input = Console.readLine();
            int numAttempts = parseNumAttempts(input);
            if (numAttempts > 0) {
                return numAttempts;
            }
        }
    }

    private static int parseNumAttempts(String input) {
        try {
            int numAttempts = Integer.parseInt(input);
            if (numAttempts <= 0) {
                System.out.println("시도 횟수는 1 이상이어야 합니다.");
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
            return numAttempts;
        } catch (NumberFormatException e) {
            System.out.println("유효한 숫자를 입력하세요.");
        }
        return 0;
    }

    private static List<String> determineWinners(List<Car> cars) {
        int maxPosition = 0;
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
                winners.clear();
                winners.add(car.getName());
            } else if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        return winners;
    }
}

class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForwardOrStop() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        if (randomValue >= 4) {
            position++;
        }
    }

    public void displayNameWithDash() {
        System.out.print(name + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
