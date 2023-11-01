package racingcar;

public class PrintCollection {
    public static void inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분");
    }
    public static void inputAttempt() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void racingResult() {
        System.out.println("실행 결과");
    }
    public static final String EXCEED_NAME_LEGNTH_EXCEPTION = "[ERROR]자동차의 이름은 5글자를 넘을 수 없습니다.";

    public static final String WRONG_NAME_EXCEPTION = "[ERROR]잘못된 값이 입력되었습니다.";
    public static final String DUPLICATE_NAME_EXCEPTION = "[ERROR]중복된 값이 입력되었습니다.";
    public static final String TOO_SMALL_ATTEMPT_EXCEPTION = "[ERROR]시도 횟수는 1회 이상이어야 합니다.";
    public static final String WRONG_NUMBER_EXCEPTION = "[ERROR]시도 횟수는 숫자여야 합니다.";

}
