package racingcar.controller;

public class OutputView {

    public static final String GET_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public void printGetCarNames() {
        System.out.println(GET_CAR_NAMES_MESSAGE);
    }

}
