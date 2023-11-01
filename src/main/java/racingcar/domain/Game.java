package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private Integer attempts;
    private Integer currentAttempt;
    private Integer maxMove;
    private List<Car> cars;

    public Game(Integer attempts) {
        this.attempts = attempts;
        this.currentAttempt = 0;
        this.maxMove = 0;
        this.cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        this.cars.add(car);
    }

    public boolean isOver() {
        return this.attempts == this.currentAttempt;
    }

    public void playStep() {
        this.currentAttempt++;
        for (Car car : this.cars) {
            updateMaxMove(car.move());
        }
        System.out.println();
    }

    private void updateMaxMove(Integer moveCount) {
        if (this.maxMove < moveCount) {
            this.maxMove = moveCount;
        }
    }

    public void printWinner() {
        System.out.print("최종 우승자 : ");
        System.out.println(cars.stream()
                .filter(car -> car.isWinner(this.maxMove))
                .map(car -> car.getName())
                .collect(Collectors.joining(", ")));
    }
}
