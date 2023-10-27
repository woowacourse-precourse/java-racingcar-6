package racingcar;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Game {
    Car[] cars;
    int roundNumber;
    Map<Car, Integer> positions;
    int winnerPosition;

    public Game(String[] carNames, int roundNumber){
        makeCars(carNames);
        initPosition();
        winnerPosition = 0;
        this.roundNumber = roundNumber;
    }

    private void initPosition() {
        positions = new HashMap<>();
        for(Car car : cars){
            positions.put(car, 0);
        }
    }

    private void makeCars(String[] carNames) {
        cars = (Car[]) Arrays.stream(carNames)
                .map((name) -> new Car(name))
                .toArray();
    }
}
