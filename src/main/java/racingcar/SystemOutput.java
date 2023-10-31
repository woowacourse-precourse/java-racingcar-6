package racingcar;

import java.util.List;

public class SystemOutput {

    public static void printInputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printInputTrialCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printThisIsResult() {
        System.out.println("실행 결과");
    }


    public static void printResult(List<Car> cars) {
        cars.forEach(car -> System.out.println(car.indicate()));
        System.out.println();
    }

    public static void printWinner(List<String> winner) {
        System.out.println(String.join(", ", winner));
    }
}
