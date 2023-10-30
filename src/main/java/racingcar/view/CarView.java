package racingcar.view;

public class CarView {
    private CarView() {}
    private static final String CAR_CREATE_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public static void printCarCreateMessage() {
        System.out.println(CAR_CREATE_MESSAGE);
    }
}
