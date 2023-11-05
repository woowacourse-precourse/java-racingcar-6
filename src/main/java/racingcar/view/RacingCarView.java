package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class RacingCarView {
    private final static String START_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String TRY_COUNT_INPUT = "시도할 회수는 몇회인가요?";
    private final static String RACING_RESULT_OUTPUT = "실행 결과";
    private final static String RACING_WINNER_OUTPUT = "최종 우승자 : ";
    private final static String NEW_LINE = "\n";

    public String getCarNameInput() {
        System.out.println(START_INPUT);
        return Console.readLine();
    }

    public String getTryCountInput() {
        System.out.println(TRY_COUNT_INPUT);
        return Console.readLine();
    }

    public void racingResultOutput() {
        System.out.println(NEW_LINE + RACING_RESULT_OUTPUT);
    }

    public void racingCarsDistanceOutput(String str) {
        System.out.println(str);
    }

    public void racingWinnerOutput(String str) {
        System.out.print(RACING_WINNER_OUTPUT + str);
    }
}
