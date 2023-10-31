package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String OUTPUT_RESULT = "실행 결과";
    private static final String OUTPUT_FINAL_WINNERS = "최종 우승자 : ";
    private static final String OUTPUT_ONE_DISTANCE = "-";
    private static final String WINNERS_DELIMITER = ", ";
    private static final String OUTPUT_EQUAL = " : ";

    public void printResult() {
        System.out.println(OUTPUT_RESULT);
    }

    public void printNameAndDistance(String name, int distance) {
        System.out.println(name + OUTPUT_EQUAL + printDistance(distance));
    }

    public String printDistance(int distance) {
        return repeat(OUTPUT_ONE_DISTANCE, distance);
    }

    private String repeat(String str, int times) {
        return str.repeat(times);
    }

    public void printWinners(List<String> carNames) {
        System.out.println(OUTPUT_FINAL_WINNERS + join(carNames));
    }

    public String join(List<String> input) {
        return String.join(WINNERS_DELIMITER, input);
    }

    public void printNewLine(){
        System.out.println();
    }
}