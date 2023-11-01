package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingGame {
    private static List<Car> createCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");

        validateCarNames(carNames); // 예외 처리: 중복 확인

        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name.trim()));
        }
        return cars;
    }

    private static void validateCarNames(String[] carNames) {
        Set<String> uniqueNames = new HashSet<>();

        for (String name : carNames) {
            if (!uniqueNames.add(name.trim())) {
                throw new IllegalArgumentException("중복된 자동차 이름이 있습니다: " + name);
            }
        }
    }

    private static int getAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }

    private void race(List<Car> cars) {
        for (Car car : cars) {
            car.moveForward();
        }
        printRaceResult(cars); // 회수마다 출력
    }

    private void printRaceResult(List<Car> cars) {
        for (Car car : cars) {
            car.printPosition();
        }
        System.out.println(); // 각 레이스 후 빈 줄 출력
    }

    private static List<String> getWinners(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public void startGame() {
        List<Car> cars = createCars();

        int attempt = getAttempts();
        System.out.println("\n실행 결과");
        for (int i = 0; i < attempt; i++) {
            race(cars);
        }

        List<String> winners = getWinners(cars);
    }

}
