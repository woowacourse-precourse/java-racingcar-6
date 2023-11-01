package racingcar.view;

import racingcar.domain.RacingCar;

import java.util.List;

public class OutputView {
    public static final String INPUT_RACINGCAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public static final String INPUT_NUMBER_OF_ROUND_MESSAGE = "시도할 횟수는 몇회인가요?";

    public static final String EXECUTION_RESULT_MESSAGE = "실행 결과";

    public static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";

    public void printInputRacingCarNameMessage() {
        System.out.println(INPUT_RACINGCAR_NAME_MESSAGE);
    }

    public void printInputNumberOfRoundMessage() {
        System.out.println(INPUT_NUMBER_OF_ROUND_MESSAGE);
    }

    public void printExecutionResultMessage() {
        System.out.println("\n" + EXECUTION_RESULT_MESSAGE);
    }

    public void printRoundResult(RacingCar racingCar) {
        System.out.print(racingCar.getName() + " : ");
        for (int i = 0; i < racingCar.getForward(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printFinalWinner(List<String> winner) {
        System.out.print(FINAL_WINNER_MESSAGE);
        System.out.print(String.join(", ", winner));
    }
}
