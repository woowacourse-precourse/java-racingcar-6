package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Cars {
    ArrayList<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }

    public void settingNames() {
        String names = Console.readLine();
        for(String name : names.split(",")) {
            cars.add(new Car(name));
        }
    }

    public void settingLogBoard(int tryChance) {
        for(Car car : cars) {
            car.settingLog(tryChance);
        }
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public Map<String, Integer> getResultOfRound() {
        HashMap<String, Integer> result = new HashMap<>();
        for(Car car : cars) {
            result.put(car.name, car.meter);
        }
        return result;
    }

    public int findMaxScore() {
        int max = Integer.MIN_VALUE;
        for(Car car : cars) {
            max = Math.max(car.meter, max);
        }
        return max;
    }

    public String findWinners(int maxScore) {
        return cars.stream()
            .filter(car -> car.meter == maxScore)
            .map(car -> car.name)
            .collect(Collectors.joining(", "));
    }
}
