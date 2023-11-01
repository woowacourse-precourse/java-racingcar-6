package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class GameView {
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPT_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RACE_RESULT = "실행 결과";
    private static final String FINAL_WINNERS = "최종 우승자 : ";

    public void printCarNamesMessage() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
    }

    public String inputCarNames() {
        String carNames = Console.readLine();
        return carNames;
    }

    public void printAttemptCountMessage() {
        System.out.println(ATTEMPT_COUNT_INPUT_MESSAGE);
    }

    public String inputAttemptCount() {
        String attemptCount = Console.readLine();
        return attemptCount;
    }

    public void printRaceResult() {
        System.out.println(RACE_RESULT);
    }

    public void printFinalWinners(String winners) {
        System.out.print(FINAL_WINNERS + winners);
    }
}
