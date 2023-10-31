package racingcar.stub;

public abstract class RacingGameStub {
    public final String CAR_NAMES = "테스트 자동차1,테스트 자동차2";
    public final String TRIAL_COUNT = "5";

    public final String RUN_RESULT_MESSAGE_MOVED = """
            테스트 자동차1 : -
            테스트 자동차2 : -
            """;

    public final String RUN_RESULT_MESSAGE_STOPPED = """
            테스트 자동차1 :\s
            테스트 자동차2 :\s
            """;

    public final String FINAL_WINNER_MESSAGE = "최종 우승자 : 테스트 자동차1, 테스트 자동차2";
}
