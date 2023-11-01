package racingcar.Domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    private final List<Car> cars;
    private int winnersDistance = 0;
    private final List<String> winners = new ArrayList<>();

    public Winner(List<Car> cars) {
        this.cars = cars;
    }

    public void printWinners() {
        checkWinnersDistance();
        checkWinner();
        System.out.print("최종 우승자 : " + String.join(", ", winners));
    }

    private void checkWinnersDistance() {
        for (Car car : this.cars) {
            if (car.getMovingDistance() > winnersDistance) {
                winnersDistance = car.getMovingDistance();
            }
        }
    }

    private void checkWinner() {
        for (Car car : this.cars) {
            if (car.getMovingDistance() == winnersDistance) {
                this.winners.add(car.getName());
            }
        }
    }
}
