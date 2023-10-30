package racingcar.ui;

import racingcar.business.Car;

public class OutputView {

    public void print(Output output) {
        System.out.println(output.getComment());
    }

    public void printMoveResult(Car car) {
        System.out.println(car.getName() + Output.SEPARATOR.getComment() + car.getDistance());
    }

}
