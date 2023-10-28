package racingcar.view;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.model.Car;

public class OutputView {

    public static void displayInitCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
    }

    public static void displayInitNumberOfAttempts() {
        System.out.println("시도할 회수는 몇 회인가요?");
    }

    public static void displayResult() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void displayCarMovements(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            printHyphens(car.getPosition());
        }
        System.out.println();
    }

    public static void displayWinners(List<String> winners) {
        System.out.print("최종 우승자 : ");
        String winnerNames = String.join(", ", winners);
        System.out.println(winnerNames);
    }

    private static void printHyphens(int count) {
        IntStream.range(0, count).mapToObj(i -> "-").forEach(System.out::print);
        System.out.println();
    }
}

