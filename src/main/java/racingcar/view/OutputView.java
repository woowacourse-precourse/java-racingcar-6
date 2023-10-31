package racingcar.view;

public class OutputView {
    // TODO: Message enum으로 빼기
    private final static String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String ASK_GAME_ROUNDS = "시도할 횟수는 몇회인가요?";
    private final static String GAME_RESULT = "실행 결과";
    private final static String DISPLAY_USER_SCORE_SIGN = ":";
    private final static String SCORE_SIGN = "-";

    public static void startGame(){
        System.out.println(START_MESSAGE);
    }

    public static void askGameRounds(){
        System.out.println(ASK_GAME_ROUNDS);
    }

    public static void gameResult(){
        System.out.println(GAME_RESULT);
    }
}
