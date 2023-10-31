package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private int numberOfAttempts;
    private List<Car> cars;
    private List<String> winners;

    public Game(int numberOfAttempts) {
        this.numberOfAttempts = numberOfAttempts;
        this.cars = new ArrayList<>();
        this.winners = new ArrayList<>();
    }

    public void addCar(String nameOfCar) {
        cars.add(new Car(nameOfCar));
    }

    /**
     * cars 리스트에 저장된 car 객체들이 한 라운드를 수행하도록 하는 함수
     */
    public void startRound() {
        for (Car car : cars) {
            car.playRound();
        }
    }
}
