package racingcar.core;

import java.util.List;

public class Output {
    private final static String ONE_STEP_RESULT = "실행 결과";
    private final static String FINAL_STEP_RESULT = "최종 우승자 :";

    public void printResult(List<String> cars) { // Car의 구현이 안되어 String으로 대체
        System.out.println(ONE_STEP_RESULT);
        for (String car : cars) {
//            System.out.print(car.getName() +" : ");
//            System.out.print(car.getStep() * "-");
            System.out.println();
        }
    }

    public void printSingleWinner(String car) {// Car의 구현이 안되어 String으로 대체
        System.out.print(FINAL_STEP_RESULT);
        System.out.print(car);
    }

    public void printMultiWinner(List<String> cars) {// Car의 구현이 안되어 String으로 대체
        System.out.print(FINAL_STEP_RESULT);

        String result = String.join(",", cars); // "pobi,jason"
        System.out.print(result);
    }
}
