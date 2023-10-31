package racingcar.view;

public class Message {
    /* Strings for user Input */
    public static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_EXECUTION_NUMBER = "시도할 회수는 몇회인가요?";

    /* Strings for user Output */
    public static final String EXECUTION_RESULT = "실행 결과";
    public static final String WINNER_NAMES = "최종 우승자 : ";

    /* Strings for exceptions */
    public static final String EXECUTION_INPUT_TYPE_ERROR = "Execution cnt must be Integer type";
    public static final String NAME_INPUT_LENGTH_ERROR = "The length of name of car is too long";
    public static final String NAME_INPUT_NULL_ERROR = "The name of car must be not null";
}
