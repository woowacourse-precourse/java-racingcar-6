package racingcar.view;

import racingcar.domain.Car;

public class OutputView {
    public void outputResult() {
        System.out.println("실행 결과");
    }

    public void outputForwardResult(Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getDistances()));
    }

}
