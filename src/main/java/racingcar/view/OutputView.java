package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {
    private final static String PROMPT_ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String PROMPT_ENTER_ATTEMPT_COUNT = "시도할 회수는 몇회인가요?";
    private final static String EXECUTION_RESULT_LABEL = "실행 결과";
    private final static String FINAL_WINNER_LABEL = "최종 우승자 : ";

    public static void printCarNamePrompt() {
        System.out.println(PROMPT_ENTER_CAR_NAMES);
    }

    public static void printAttemptCountPrompt() {
        System.out.println(PROMPT_ENTER_ATTEMPT_COUNT);
    }

    public static void printResultLabel() {
        System.out.println(EXECUTION_RESULT_LABEL);
    }

    public static void printRoundResult(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(String.format("%s : %s", car.getName(), car.getPositionString()));
        }
        System.out.println();
    }

    public static void printFinalResult(List<String> winnerList) {
        String result;
        if (getNumberOfWinners(winnerList) > 1) {
            generateWinnersString(winnerList);
            result = FINAL_WINNER_LABEL + generateWinnersString(winnerList);
        } else {
            result = FINAL_WINNER_LABEL + winnerList.get(0);
        }
        System.out.println(result);
    }

    private static int getNumberOfWinners(List<String> winnerList) {
        return winnerList.size();
    }

    private static String generateWinnersString(List<String> winnerList) {
        StringJoiner joiner = new StringJoiner(", ");
        for (String name : winnerList) {
            joiner.add(name);
        }
        return joiner.toString();
    }
}
