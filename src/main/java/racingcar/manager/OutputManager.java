package racingcar.manager;

import java.util.List;
import racingcar.domain.Car;

public class OutputManager {

    private List<Car> cars;

    public OutputManager(List<Car> cars) {
        this.cars = cars;
    }

    public void printInterResult() {
        System.out.println("\n실행 결과");
        for (Car car : cars) {
            System.out.println(car.getState());
        }
    }

    public void printWinner() {
        Referee referee = new Referee(cars);
        List<String> winners = referee.selectWinner();
        String winnerMessage = String.join(", ", winners);

        System.out.println("\n최종 우승자 : " + winnerMessage);
    }
}
