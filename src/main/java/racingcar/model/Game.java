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

    private void addCar(String nameOfCar) {
        cars.add(new Car(nameOfCar));
    }

    /**
     * userInput 을 받아 name을 분리하고 cars 리스트에 car 를 추가하는 함수
     */
    public void addCars(String userInput) {
        String[] nameList = userInput.split(",");
        for (String name : nameList) {
            addCar(name);
        }
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
