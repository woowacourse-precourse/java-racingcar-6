package racingcar.io;

import java.util.List;

public class Output {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String FINAL_RESULT_MESSAGE = "최종 우승자 : ";


    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printRacingResult(List<String> racingCarStatus) {
        racingCarStatus.forEach(System.out::println);
        System.out.println();
    }

    public void printFinalRacingResult(String result) {
        System.out.println(FINAL_RESULT_MESSAGE + result);
    }
}
