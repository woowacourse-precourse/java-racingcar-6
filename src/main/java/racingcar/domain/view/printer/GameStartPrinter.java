package racingcar.domain.view.printer;

public class GameStartPrinter {
    private static final String RACINGCAR_NAME_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public static void printCarName() {
        System.out.println(RACINGCAR_NAME_REQUEST_MESSAGE);
    }
}
