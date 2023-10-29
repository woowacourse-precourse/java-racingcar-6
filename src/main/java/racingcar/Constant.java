package racingcar;

public class Constant {
    public final static String MESSAGE_INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public final static String MESSAGE_INPUT_MOVE_COUNT = "시도할 회수는 몇회인가요?";
    public final static String MESSAGE_WINNER = "최종 우승자";
    public final static String MESSAGE_OUTPUT = "\n실행 결과";

    public final static String INPUT_DELIM = ",";
    public final static String OUTPUT_DELIM = ", ";
    public final static String IS = " : ";
    public final static String LINE = "-";

    public final static int START = 0;
    public final static int END = 9;
    public final static int MOVING_FORWARD = 4;

    public final static int MAX_NAME_LENGTH = 5;

    public final static String ERROR_INPUT_MOVE_COUNT = "GameManager : parseAndCheckValid : not normal input";
    public final static String ERROR_INPUT_NAME = "CarListFactory : checkValidName : not valid name";
}
