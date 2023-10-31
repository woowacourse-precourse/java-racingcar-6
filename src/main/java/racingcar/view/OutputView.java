package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    private static final String PRINT_RESULT_MESSAGE = "실행 결과";
    private static final String PRINT_WINNER_MESSAGE = "최종 우승자 : ";

    // "실행 결과" 출력
    public static void printResultHeader() {
        System.out.println(PRINT_RESULT_MESSAGE);
    }

    // 한번 경기가 끝나고 결과 출력
    public static void printResult(List<Car> cars) {
        cars.forEach(car -> {
            printCarStatus(car);
            System.out.println();
        });
        System.out.println();
    }

    // 한 경기에, 한 자동차의 상태 출력
    private static void printCarStatus(Car car) {
        System.out.print(car.getName() + " : ");
        printDistance(car);
    }

    // 한 자동차의 이동한 거리 출력
    private static void printDistance(Car car) {
        for (int i = 0; i < car.getDistance(); i++) {
            System.out.print("-");
        }
    }

    // 최종 우승자 출력
    public static void printWinner(List<String> cars) {
        System.out.print(PRINT_WINNER_MESSAGE);
        String concatenatedNames = String.join(", ", cars);
        System.out.println(concatenatedNames);
    }
}