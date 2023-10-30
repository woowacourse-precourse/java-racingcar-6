package racingcar;

import java.util.List;

import static racingcar.RacingGameMessage.*;

public class PrintHandler {
//    public class RacingGameMessage {
//        public static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
//        public static final String INPUT_TRIAL_NUMBER = "시도할 회수는 몇회인가요?";
//        public static final String RESULT_RUNNING = "실행 결과";
//        public static final String FINAL_WINNER = "최종 우승자 : ";
//    }
    public static void inputCarNamesPrompt() {
        System.out.println(INPUT_CAR_NAMES_PROMPT);
    }

    public static void inputTrialNumberPrompt() {
        System.out.println(INPUT_TRIAL_NUMBER_PROMPT);
    }

    public static void resultRunningSentence() {
        System.out.println("\n" + RESULT_RUNNING_SENTENCE);
    }

    public static void finalWinnerSentence() {
        System.out.print(FINAL_WINNER_SENTENCE);
    }

    public static void resultRunning(List<Car> cars) {
        for (Car car : cars) {
            System.out.printf(car.getName() + RESULT_SEPARATOR);
            printDash(car.getLocation());
            System.out.println();
        }
        System.out.println();
    }

    public static void finalWinner() {

    }

    private static void printDash(int location) {
        for (int i = 0; i < location; i++) {
            System.out.print("-");
        }
    }
}
