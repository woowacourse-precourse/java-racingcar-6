package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Winners;

import java.util.List;

public class Output {
    private static final String inputCarName = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String number_of_attempts = "시도할 횟수는 몇회인가요?";
    private static final String execution_result = "실행 결과";

    private static final String distance_mark = "-";

    private static final String comma = ", ";


    public static void inputCarName() {
        System.out.println(inputCarName);
    }

    public static void printNumber_of_attempts() {
        System.out.println(number_of_attempts);
    }

    public static void printExecutionResult() {
        System.out.println(execution_result);
    }

    public static void printCarScore(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            printPosition(car);
        }
        System.out.println();
    }

    private static void printPosition(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(distance_mark);
        }
        System.out.println();
    }


    public static void printWinner(Winners winners) {
        System.out.print("최종 우승자 : ");
        String lastWinners = String.join(comma, winners.getWinnerNames());
        System.out.println(lastWinners);
    }

}
