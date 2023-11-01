package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_NUMBER_OF_TRIES_MESSAGE = "시도할 횟수는 몇회인가요?";
    public static String printInputCarNamesMessage() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        return Console.readLine();
    }
    public static String printInputNumberOfGamesMessage() {
        System.out.println(INPUT_NUMBER_OF_TRIES_MESSAGE);
        return Console.readLine();
    }
}
