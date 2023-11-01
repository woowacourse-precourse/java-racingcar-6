package racingcar.Domain;

import static racingcar.common.GameMessage.FINAL_WINNER_MESSAGE;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    private final List<Car> cars;
    private int winnersDistance = 0;
    private final List<String> winners = new ArrayList<>();

    private final static String DELIMITER = ", ";

    public Winner(List<Car> cars) {
        this.cars = cars;
    }

    public void printWinners() {
        checkWinnersDistance();
        checkWinner();
        System.out.print(FINAL_WINNER_MESSAGE + String.join(DELIMITER, winners));
    }

    private void checkWinnersDistance() {
        this.winnersDistance = this.cars.stream()
                .mapToInt(Car::getMovingDistance)
                .max()
                .orElse(0);
    }

    private void checkWinner() {
        this.cars.stream()
                .filter(car -> car.getMovingDistance() == this.winnersDistance)
                .map(Car::getName)
                .forEach(this.winners::add);
    }
}
