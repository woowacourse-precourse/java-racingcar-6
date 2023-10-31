package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Track {
    private List<Car> track;

    public void addCars(List<String> cars) {
        track = new ArrayList<>();
        for(int i = 0; i < cars.size(); i++) {
            String name = cars.get(i);
            track.add(new Car(name));
        }
    }

    public void moveCars() {
        for(Car car : track) {
            car.move();
        }
    }

    public String showProgress() {
        StringBuilder sb = new StringBuilder();
        for(Car car : track) {
            sb.append(car.getName());
            sb.append(" : ");
            for(int i = 0; i < car.getDistance(); i++) {
                sb.append("-");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public String showResult() {
        String result = findWinners().toString();
        return result.substring(1, result.length()-1);
    }
    private Car findFirstPlace() {
        Collections.sort(track);
        return track.get(0);
    }

    private List<String> findWinners() {
        Car firstPlace = findFirstPlace();
        List<String> winners = new ArrayList<>();
        for (Car car : track) {
            if (firstPlace.compareTo(car) >= 0) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
