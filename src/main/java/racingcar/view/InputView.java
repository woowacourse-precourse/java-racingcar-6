package racingcar.view;

public class InputView {
    public static final String INPUT_CARS = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_ATTEMPTS_NUM = "시도할 회수는 몇 회인가요?";

    public static void inputCars() {
        System.out.println(INPUT_CARS);
    }

    public static void inputAttemptsNum() {
        System.out.println(INPUT_ATTEMPTS_NUM);
    }
}
