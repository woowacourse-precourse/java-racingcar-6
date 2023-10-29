package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class ForInputMessage {

    private static final String FOR_INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String FOR_INPUT_RACE_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    public static String forInputCarNamesMessage() {
        System.out.println(FOR_INPUT_CAR_NAMES_MESSAGE);
        return Console.readLine();
    }

    public static String forInputRaceCountMessage() {
        System.out.println(FOR_INPUT_RACE_COUNT_MESSAGE);
        return Console.readLine();
    }

}
