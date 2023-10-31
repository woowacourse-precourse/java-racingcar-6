package racingcar.manager;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Referee;

public class OutputManager {

    private List<Car> cars;
    private Referee referee;

    public OutputManager(List<Car> cars) {

        this.cars = cars;
        referee = new Referee(cars);
    }

    public void printInterResult() {

        for (Car car : cars) {
            System.out.println(car.getState());
        }
        System.out.println();
    }

    public void printWinner() {

        List<String> winners = referee.selectWinner();
        String winnerMessage = String.join(", ", winners);

        System.out.println("최종 우승자 : " + winnerMessage);
    }
}
