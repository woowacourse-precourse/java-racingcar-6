package racingcar.domain;

public class Logs {
    private Logs() {

    }

    public static void inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void inputGameTurns() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void newLine() {
        System.out.println();
    }

    public static void getGameResult() {
        System.out.println("실행 결과");
    }

    public static void car(Car car) {
        System.out.println(car);
    }

    public static void string(String winners) {
        System.out.println(winners);
    }
}
