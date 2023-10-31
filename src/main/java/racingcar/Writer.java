package racingcar;

public final class Writer {
    private static final String OPENING = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_ATTEMPTS = "시도할 회수는 몇회인가요?";
    private static final String RESULTS = "실행 결과";

    private Writer() {
        throw new UnsupportedOperationException();
    }

    public static void opening() {
        System.out.println(OPENING);
    }

    public static void askAttempts() {
        System.out.println(ASK_ATTEMPTS);
    }

    public static void results() {
        System.out.println(RESULTS);
    }

    public static void cars(Cars cars) {
        System.out.println(cars);
    }
}
