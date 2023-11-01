package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private int numberOfAttempts;
    private List<Car> cars;
    private List<String> winners;

    public Game() {
        this.numberOfAttempts = 0;
        this.cars = new ArrayList<>();
        this.winners = new ArrayList<>();
    }

    public void setNumberOfAttempts(int numberOfAttempts) {
        this.numberOfAttempts = numberOfAttempts;
    }

    private void addCar(String nameOfCar) {
        cars.add(new Car(nameOfCar));
    }

    /**
     * cars 리스트에 car 를 추가하는 함수
     */
    public void addCars(String userInput) {
        for (String name : splitNameOfCars(userInput)) {
            addCar(name);
        }
    }

    /**
     * userInput 을 받아 name을 분리하는 함수
     */
    private String[] splitNameOfCars(String userInput) {
        return userInput.split(",");
    }

    /**
     * cars 리스트에 저장된 car 객체들이 한 라운드를 수행하도록 하는 함수
     */
    public void startRound() {
        for (Car car : cars) {
            car.playRound();
        }
    }

    /**
     * 각 라운드의 자동차들 전진 결과를 출력하는 함수
     */
    public void printResultOfRound() {
        for (Car car : this.cars) {
            System.out.println(car.getNameAndStateOfCar());
        }
    }

    /**
     * 가장 많이 전진한 자동차의 전진 횟수를 리턴하는 함수
     */
    public int findMaxForwardMovement() {
        int max = 0;
        for (Car car : cars) {
            if (max < car.getForwardMovementStateOfLength()) {
                max = car.getForwardMovementStateOfLength();
            }
        }
        return max;
    }

    /**
     * 자동차들의 전진 상황을 비교하여 우승자를 저장하는 함수
     */
    public void findWinners() {
        int max = findMaxForwardMovement();
        for (Car car : cars) {
            if (car.getForwardMovementStateOfLength() == max) {
                this.winners.add(car.getName());
            }
        }
    }

    /**
     * 단독 우승자인지 확인하는 함수
     */
    public boolean checkIsSoloWinner() {
        return winners.size() == 1;
    }

    /**
     * 최종 우승자를 출력할 결과를 String으로 반환하는 함수
     */
    public String getWinnersResult() {
        StringBuilder result = new StringBuilder("최종 우승자 : ");
        if (checkIsSoloWinner()) { // 단독 우승이라면
            result.append(winners.get(0));
        } else if (!checkIsSoloWinner()) { // 단독 우승이 아니라면
            for (String winner : this.winners) {
                result.append(winner);
            }
            result.append(", ");
        }
        return String.valueOf(result);
    }

    public int getNumberOfAttempts() {
        return this.numberOfAttempts;
    }

    public int getNumberOfCars() {
        return this.cars.size();
    }

}
