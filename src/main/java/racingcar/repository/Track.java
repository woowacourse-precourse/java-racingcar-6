package racingcar.repository;

import java.util.HashMap;
import java.util.Map;
import racingcar.model.Car;

public class Track {

    private static final Map<Car, Integer> track = new HashMap<>();

    public void init() {
        track.clear();
    }

    public void stand(Car car) {
        track.put(car, 0);
    }

    public void move(Car car, int randomNumber) {
        if(randomNumber > 3) {
            int index = track.get(car);
            track.put(car, ++index);
        }
    }

    public String winners() {
        int max = max();
        String winners = track.keySet().stream()
                .filter(k -> max == track.get(k))
                .map(Car::getName)
                .toList()
                .toString();
        return winners.substring(1, winners.length()-1);
    }

    private int max() {
        int max = 0;
        for(int l : track.values()) {
            max = Math.max(max, l);
        }
        return max;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        track.keySet().forEach(car ->
                sb.append(car.getName())
                        .append(" : ")
                        .append("-".repeat(track.get(car)))
                        .append("\n")
        );
        return sb.toString();
    }
}
