package racingcar.View;

public class OutputView {
    private final static String INPUT_RACING_CAR = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String INPUT_RACING_COUNT = "시도할 회수는 몇회인가요?";

    public static void printInputRacingCar() {
        System.out.println(INPUT_RACING_CAR);
    }

    public static void printInputRacingCount() {
        System.out.println(INPUT_RACING_COUNT);
    }
}
