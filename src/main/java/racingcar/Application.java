package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        racingGame();
    }

    private static void racingGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarNames = Console.readLine();
        List<Car> cars = parsingCarNames(inputCarNames);

        System.out.println("시도할 회수는 몇회인가요?");
        String inputTryCount = Console.readLine();
        int tryCount = parsingTryCount(inputTryCount);

        System.out.println("\n실행 결과");
        for (int i = 0; i < tryCount; i++) {
            printCarStatus(cars);
        }
        printWinners(cars);
    }

    private static List<Car> parsingCarNames(String inputCarNames) {
        String[] splitNames = inputCarNames.split(",");
        Validate.carNames(splitNames);
        return Arrays.stream(splitNames).map(Car::new).toList();
    }

    private static int parsingTryCount(String inputTryCount) {
        Validate.number(inputTryCount);
        return Integer.parseInt(inputTryCount);
    }

    private static void printCarStatus(List<Car> cars) {
        for (Car car : cars) {
            car.move(Randoms.pickNumberInRange(0, 9));
        }
        printCurrentStatus(cars);
        System.out.println();
    }

    private static void printCurrentStatus(List<Car> cars) {
        cars.forEach(car -> {
            System.out.print(car.getName() + " : ");
            System.out.println(car.getPositionString());
        });
    }

    private static void printWinners(List<Car> cars) {
        List<String> winners = findWinners(cars);
        String winnersString = joinWinners(winners);
        System.out.print("최종 우승자 : " + winnersString);
    }

    private static List<String> findWinners(List<Car> cars) {
        int maxPosition = findMaxPosition(cars);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    private static int findMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    private static String joinWinners(List<String> winners) {
        return String.join(", ", winners);
    }
}
