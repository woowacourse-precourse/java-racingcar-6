package racingcar.util;

public class CarUtil {
    public static final String CAR_NAME_SPLIT = ",";
    public static final String SHOW_MOVE_DISTANCE = "-";
    public static final String WINNER_SEPARATOR = ", ";
    public static final int FIRST_SCORE = 0;
    public static final int MIN_POSSIBLE_MOVE_NUMBER = 4;
    public static final int MAX_CAR_NAME_LENGTH = 5;
    public static final int MIN_RANDOM_NUMBER = 0;
    public static final int MAX_RANDOM_NUMBER = 9;
    private static final String RESULT = "실행 결과";
    private static final String VICTORY = "최종 우승자 : ";
    private static final String INPUT_CAR_LIST = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ROUND = "시도할 회수는 몇회인가요?";

    public static void printNewLine() {
        System.out.println();
    }

    public static void printGetCarList() {
        System.out.println(INPUT_CAR_LIST);
    }

    public static void printGetRound() {
        System.out.println(INPUT_ROUND);

    }

    public static void printResult() {
        System.out.println(RESULT);
    }

    public static void printMoveCar(String name, String moveString) {
        System.out.println(name + " : " + moveString);
    }

    public static void printVictory(String winnerNames) {
        System.out.println(VICTORY + winnerNames);
    }
}
