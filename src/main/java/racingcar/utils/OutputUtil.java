package racingcar.utils;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.car.Car;
import racingcar.race.Race;

public class OutputUtil {
    public static void printStatus(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winnerNames);
    }

    public static void printStartMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printAttemptMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printCarStatus(Race race) {
        for (Car car: race.getCars()) {
            OutputUtil.printStatus(car);
        }
        System.out.println();
    }

    public static void printExecutionResultMessage() {
        System.out.println("\n실행 결과");
    }
}
