package racingcar.view;

import racingcar.domain.Car;

public class OutputView {
    public void printCarInfo(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
