package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.print("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분): ");
        String carNamesInput = Console.readLine();
        String[] carNames = carNamesInput.split(",");
        validateCarNames(carNames);

        System.out.print("시도할 회수는 몇회인가요? ");
        String tryCountInput = Console.readLine();
        int tryCount = parseTryCount(tryCountInput);

        List<Car> cars = createCars(carNames);
        printExecutionResults(tryCount, cars);

        int maxPosition = getMaxPosition(cars);
        List<String> winners = getWinners(cars, maxPosition);

        System.out.println("최종 우승자: " + String.join(", ", winners));
    }

    private static void validateCarNames(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    private static int parseTryCount(String tryCountInput) {
        try {
            return Integer.parseInt(tryCountInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    private static List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private static void printExecutionResults(int tryCount, List<Car> cars) {
        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                car.move(Randoms.pickNumberInRange(0, 9));
                System.out.println(car);
            }
            System.out.println();
        }
    }

    private static int getMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    private static List<String> getWinners(List<Car> cars, int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}

class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move(int number) {
        if (number >= 4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }
}
