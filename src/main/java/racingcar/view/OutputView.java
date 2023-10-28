package racingcar.view;

import racingcar.model.Car;

public class OutputView {
    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        return instance;
    }

    private OutputView() {
    }

    public void printResultInfo() {
        System.out.println("실행 결과");
    }

    public void printResult(Car car) {
        System.out.println(car.getName() + " : " + car.getResult());
    }

}
