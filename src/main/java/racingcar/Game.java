package racingcar;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Game {
    Car[] cars;
    Map<Car, Integer> positions;
    int winnerPosition;

    public Game(String[] carNames){
        makeCars(carNames);
        initPosition();
        winnerPosition = 0;
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
