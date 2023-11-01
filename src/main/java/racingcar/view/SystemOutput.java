package racingcar.view;

import java.util.List;

public class SystemOutput {

    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRIAL_COUNT = "시도할 회수는 몇회인가요?";
    private static final String THIS_IS_RESULT = "\n실행 결과";
    private static final String WINNER = "최종 우승자 : ";

    public static void printInputCarNames() {
        System.out.println(INPUT_CAR_NAMES);
    }

    public static void printInputTrialCount() {
        System.out.println(INPUT_TRIAL_COUNT);
    }

    public static void printThisIsResult() {
        System.out.println(THIS_IS_RESULT);
    }


    public static void printResult(List<String> indicator) {
        indicator.forEach(System.out::println);
        System.out.println();
    }

    public static void printWinner(List<String> winner) {
        System.out.println(WINNER + String.join(", ", winner));
    }
}
