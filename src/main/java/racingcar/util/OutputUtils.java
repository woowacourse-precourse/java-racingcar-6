package racingcar.util;

import racingcar.model.Car;

import java.util.List;

public class OutputUtils {

    public static void printReadCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printReadTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printTitleResult() {
        System.out.println("실행 결과");
    }

    public static void printResultPerTry(List<Car> cars) {
        cars.forEach(car -> System.out.println(car.getName() + " : " + "-".repeat(car.getMovement())));
        System.out.println();
    }

    public static void printFinalWinners(List<String> winnerNames) {
        System.out.println("최종 우승자 : " + String.join(", ", winnerNames));
    }
}
