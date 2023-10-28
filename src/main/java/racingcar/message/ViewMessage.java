package racingcar.message;

public class ViewMessage {
    private ViewMessage() {} // 인스턴트화 방지
    public static String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static String INPUT_TRIAL_COUNT = "시도할 회수는 몇회인가요?";
    public static String GAME_RESULT = "실행 결과";
    public static String WINNER_RESULT_FORMAT = "최종 우승자 : %s";
}
