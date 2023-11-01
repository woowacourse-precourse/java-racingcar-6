package racingcar;


import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;


public class CarRacingGame {
    private List<Car> cars;
    private int totalMoves;

    public CarRacingGame(List<Car> cars) {
        this.cars = cars;
        this.totalMoves = 0;
    }

    public void playGame(int numberOfMoves) {
        if (numberOfMoves <= 0) {
            throw new IllegalArgumentException("이동할 횟수는 양수여야 합니다.");
        }

        totalMoves = numberOfMoves;

        for (int move = 0; move < numberOfMoves; move++) {
            for (Car car : cars) {
                int randomValue = Randoms.pickNumberInRange(0, 9); // Randoms 클래스 사용
                if (randomValue >= 4) {
                    car.moveForward();
                }
            }
        }
    }

    public int getTotalMoves() {
        return totalMoves;
    }

    public List<Car> getCars() {
        return cars;
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
