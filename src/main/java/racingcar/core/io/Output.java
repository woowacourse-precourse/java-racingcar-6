package racingcar.core.io;

import racingcar.domain.Car;

import java.util.List;

public class Output {
    private final static String ONE_STEP_RESULT = "실행 결과";
    private final static String FINAL_STEP_RESULT = "최종 우승자 : ";

    public void printResult(List<Car> cars) { // Car의 구현이 안되어 String으로 대체
        System.out.println(ONE_STEP_RESULT);
        for (Car car : cars) {
            System.out.print(car.getName() +" : ");
            System.out.print("-".repeat(car.getCurrentStep()));
            System.out.println();
        }
    }
    public void printWinner(List<String> cars) {
        System.out.print(FINAL_STEP_RESULT);

        String result = String.join(",", cars); // "pobi,jason"
        System.out.print(result);
    }
}
