package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MIN_ROUND = 0;
    private static final int MIN_DISTANCE = 0;
    private static final int MAX_DISTANCE = 0;
    private static final int MIN_MOVE_DISTANCE = 4;

    public static void main(String[] args) {
        String[] carNames = readCarNames();
        validateCarName(carNames);
        Car[] cars = initializeCars(carNames);
        int round = readRoundNumber();
        System.out.println("실행 결과");
        for (int i = 0; i < round; i++) {
            playOneRound(cars);
        }
        ist<String> winners = determineWinners(cars);
        printWinners(winners);
    }

    private static String[] readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine().split(",");
    }

    private static void validateCarName(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static Car[] initializeCars(String[] carNames) {
        int carNumber = carNames.length;
        Car[] cars = new Car[carNumber];
        for (int i = 0; i < carNumber; i++) {
            cars[i] = new Car(carNames[i]);
        }
        return cars;
    }

    private static int readRoundNumber() {
        System.out.println("시도할 횟수는 몇회인가요?");
        int round = Integer.parseInt(Console.readLine());
        if (round < MIN_ROUND) {
            throw new IllegalArgumentException();
        }
        return round;
    }

    private static void playOneRound(Car[] cars) {
        for (Car car : cars) {
            int distance = Randoms.pickNumberInRange(MIN_DISTANCE, MAX_DISTANCE);
            if (distance >= MIN_MOVE_DISTANCE) {
                car.move(distance);
            }
            car.printDistance();
        }
        System.out.println();
    }

    private static void printWinners(List<String> winners) {
        StringBuilder result = new StringBuilder("최종 우승자 : ");
        for (String winner : winners) {
            result.append(winner).append(", ");
        }
        System.out.println(result.substring(0, result.length() - 2));
    }
}
