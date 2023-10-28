package racingcar.manager;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Referee;

public class OutputManager {

    private List<Car> cars;

    public OutputManager(List<Car> cars) {

        this.cars = cars;
    }

    public void printInterResult() {

        for (Car car : cars) {
            System.out.println(car.getState());
        }
        System.out.println();
    }

    public void printWinner() {

        Referee referee = new Referee(cars);
        List<String> winners = referee.selectWinner();
        String winnerMessage = String.join(", ", winners);

        System.out.println("최종 우승자 : " + winnerMessage);
    }
}
