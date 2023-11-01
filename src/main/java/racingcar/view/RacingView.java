package racingcar.view;

public class RacingView {

    private static final String START_GAME_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ENTER_ROUND_MSG = "시도할 회수는 몇회인가요?";

    public static void startGameMessage() {
        System.out.println(START_GAME_MSG);
    }

    public static void enterRoundMessage() {
        System.out.println(ENTER_ROUND_MSG);
    }
}
