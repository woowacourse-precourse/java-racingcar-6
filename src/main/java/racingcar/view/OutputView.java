package racingcar.view;

import java.util.Collection;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {

    public void printExecutionResultMessage() {
        System.out.println("실행 결과");
    }

    public void printMoveResult(Cars cars) {
        Collection<Car> carList = cars.getCars();

        for (Car car : carList) {
            System.out.println(car.getName() + " : " + car.showDistance());
        }

        System.out.println();
    }

    public void printWinner(List<String> winners) {
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winners));
    }
}
