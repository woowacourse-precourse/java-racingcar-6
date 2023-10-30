package racingcar.view;

import racingcar.model.Cars;

public record OutputView() {
    private static final String RESULT_MESSAGE = "실행 결과";

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printResult(Cars cars) {
        cars.getCars().forEach(System.out::println);
        System.out.println();
    }
}
