package racingcar;

public final class Writer {
    private static final String OPENING = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private Writer() {
        throw new UnsupportedOperationException();
    }

    public static void opening() {
        System.out.println(OPENING);
    }


}
