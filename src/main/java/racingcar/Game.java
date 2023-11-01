package racingcar;

import java.util.*;

import static racingcar.Util.generateRandomNumber;

public class Game {
    private int trial;
    private ArrayList<Car> racingCars;

    public Game(List<String> carNames, int trial) {
        this.trial = trial;
        this.racingCars = new ArrayList<>();
        for (String carName : carNames) {
            racingCars.add(new Car(carName));
        }
    }

    public void start() {
        for (int i=0;i<trial;i++) {
            moveCars();
            printCurrentRace();
        }
    }

    public void moveCars() {
        for (Car car : racingCars) {
            if (generateRandomNumber() >= 4) {
                car.addDistance(1);
            }
        }
    }

    public void printCurrentRace() {
        for (Car car : racingCars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
        }
        System.out.println();
    }

    public HashMap<String, Integer> result() {
        HashMap<String, Integer> result = new HashMap<>();
        for (Car car : racingCars) {
            result.put(car.getName(), car.getDistance());
        }
        return result;
    }

    public ArrayList<String> findWinners(HashMap<String, Integer> winnerList) {
        ArrayList<String> winnerNames = new ArrayList<>();
        Integer maxDistance = Collections.max(winnerList.values());

        winnerList.forEach((name,distance) -> {
            if (Objects.equals(distance, maxDistance)) {
                winnerNames.add(name);
            }
        });

        return winnerNames;
    }

}
