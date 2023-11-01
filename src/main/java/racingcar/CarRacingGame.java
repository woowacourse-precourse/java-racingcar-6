package racingcar;


import java.util.*;

public class CarRacingGame {
    private List<Car> cars;
    private int totalMoves;

    public CarRacingGame(List<Car> cars) {
        this.cars = cars;
        this.totalMoves = 0;
    }

    public void playGame(int numberOfMoves) {
        totalMoves = numberOfMoves;

        for (int move = 0; move < numberOfMoves; move++) {
            for (Car car : cars) {
                int randomValue = new Random().nextInt(10);
                if (randomValue >= 4) {
                    car.moveForward();
                }
            }
        }
    }

    public List<Car> determineWinners() {
        List<Car> winners = new ArrayList<>();
        int maxDistance = 0;

        for (Car car : cars) {
            int distance = car.getDistance();
            if (distance > maxDistance) {
                maxDistance = distance;
                winners.clear();
                winners.add(car);
            } else if (distance == maxDistance) {
                winners.add(car);
            }
        }

        return winners;
    }
}
