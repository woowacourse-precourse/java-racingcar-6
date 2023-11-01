package racingcar.view;

import java.util.List;

public class RacingGameOutputView {
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACING_ROUND_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String FINAL_WINNER_ANNOUNCED_MESSAGE = "최종 우승자 : ";
    private static final String DELIMITER = ", ";

    public void print(String T) {
        System.out.printf("%s", T);
    }

    public void println(String T) {
        System.out.println(T);
    }

    public void printCarNameInputMessage() {
        println(CAR_NAME_INPUT_MESSAGE);
    }

    public void printRacingRoundInputMessage() {
        println(RACING_ROUND_INPUT_MESSAGE);
    }

    public void printFinalWinnerAnnouncedMessage(List<String> winners) {
        print(FINAL_WINNER_ANNOUNCED_MESSAGE);
        println(String.join(DELIMITER, winners));
    }
}