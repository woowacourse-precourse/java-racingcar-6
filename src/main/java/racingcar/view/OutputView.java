package racingcar.view;

public class OutputView {

    private static final String RACE_START_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉽표(,) 기준으로 구분)";

    public static void printRaceStartMessage() {
        System.out.println(RACE_START_MESSAGE);
    }
}
