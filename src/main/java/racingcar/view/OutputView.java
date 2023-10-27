package racingcar.view;

import java.util.List;
import racingcar.Domain.Car;

public class OutputView {
    public void printExecutuionResult() {
        System.out.println("실행 결과");
    }
    public void printCarScore(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            printPostion(car);
            System.out.println();
        }
    }

    public void printWinners() {

    }

    public void printPosition(Car car) {
        for(int i = 0; i < car.getPostion(); i++) {
            System.out.print("-");
        }
    }
}
