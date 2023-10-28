package constant;

import domain.Car;

public class ConstantString {
    public static int MAX_NAME_LENGTH = 5;
    public static int MIN_NUMBER_RANGE = 1;
    public static int MAX_NUMBER_RANGE = 9;
    public static int MOVING_FORWARD = 4;
    public static int MIN_ATTEMPTS = 1;
    public static int DEFAULT_MAX_COUNT = 0;
    public static int INITIAL_MOVE_COUNT = 0;

    public static String DELIMITER = ",";
    public static String HYPHEN = "-";
    public static String WINNER_DELIMITER = ", ";

    public static String ENTER_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static String ATTEMPT_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    public static String EXECUTION_RESULT = "실행 결과";
    public static String FINAL_WINNER = "최종 우승자 : ";

    public static String processMessage(Car car) {
        return car.getCarName() + " : " + HYPHEN.repeat(car.getCount());
    }
}
