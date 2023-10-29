package racingcar.model;

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
        return cars.stream()
            .mapToInt(car -> car.meter)
            .max()
            .orElse(Integer.MIN_VALUE);
    }

    public ArrayList<String> findWinners() {
        return cars.stream()
            .filter(car -> car.meter == findMaxScore())
            .map(car -> car.name)
            .collect(Collectors.toCollection(ArrayList::new));
    }
}
