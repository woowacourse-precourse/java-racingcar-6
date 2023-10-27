package racingcar.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import racingcar.domain.Car;

public class PrintResult {
    public void printWinner(List<Car> cars) {
        HashMap<Integer, List<String>> distanceToCarName = new HashMap<>(); //<distance, CarName>
        int maxDistance = Integer.MIN_VALUE;
        for (Car car : cars) {
            int distance = car.getDistance().length();
            maxDistance = Math.max(maxDistance, distance);

            if (!distanceToCarName.containsKey(distance)) {
                distanceToCarName.put(distance, new ArrayList<>());
            }
            distanceToCarName.get(distance).add(car.getName());
        }
        StringBuilder winner = new StringBuilder();
        for (String name : distanceToCarName.get(maxDistance)) {
            winner.append(name).append(", ");
        }

        if (winner.length() > 0) {
            winner.setLength(winner.length() - 2);
        }

        System.out.println("최종 우승자 : " + winner.toString());
    }
}
