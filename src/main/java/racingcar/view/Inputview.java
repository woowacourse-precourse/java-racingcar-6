package racingcar.view;

import java.util.List;

public class Inputview {

    private static final String GAME_START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String GAME_NUMBER_OF_ATTEMPTS = "시도할 회수는 몇회인가요?";

    public static void startGame() {
        System.out.println(GAME_START_MESSAGE);
    }

    public List<String> inputCarName() {
        return null;
    }

    public static void tryGameNumber() {
        System.out.println(GAME_NUMBER_OF_ATTEMPTS);
    }

    public int carNumericValue() {
        return 0;
    }
}
