package racingcar.view;

import java.util.List;
import racingcar.domain.RacingCar;

public class OutputView {

    private static final String INPUT_RACING_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TOTAL_ATTEMPTS = "시도할 회수는 몇회인가요?";
    private static final String RUN_RESULT = "실행 결과";
    private static final String COLON_SPACE = " : ";
    private static final String DASH = "-";
    private static final String FINAL_WINNER = "최종 우승자: ";
    private static final String COMMA_SPACE = ", ";

    public void printInputRacingCarNames() {
        System.out.println(INPUT_RACING_CAR_NAMES);
    }

    public void printInputTotalAttempts() {
        System.out.println(INPUT_TOTAL_ATTEMPTS);
    }

    public void printGameProgress(List<RacingCar> racingCarList) {
        printRunResult();

        racingCarList.forEach(racingCar -> {
            String progressString = toProgressString(racingCar);
            System.out.println(progressString);
            printNewLine();
        });
    }

    public void printFinalWinner(List<String> winners) {
        System.out.println(FINAL_WINNER + String.join(COMMA_SPACE, winners));
    }

    private String toProgressString(RacingCar racingCar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(racingCar.getName())
            .append(COLON_SPACE)
            .append(DASH.repeat(racingCar.getPosition()));
        return stringBuilder.toString();
    }

    private void printRunResult() {
        System.out.println(RUN_RESULT);
    }

    public void printNewLine() {
        System.out.println();
    }

}
