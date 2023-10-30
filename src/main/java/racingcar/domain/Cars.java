package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
    ArrayList<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }

    public void settingNames() {
        String names = Console.readLine();
        hasComma(names);
        validateDuplicateName(names);
        for(String name : names.split(",")) {
            cars.add(new Car(name.trim()));
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

    private void hasComma(String name) {
        if(!name.contains(",")) {
            throw new IllegalArgumentException("이름을 쉼표(,)로 구분해야 합니다. 또한, 최소 2대 이상의 자동차가 필요합니다.");
        }
    }

    private void validateDuplicateName(String name) {
        String[] names = name.split(",");
        Set<String> nameSet = new HashSet<>(Arrays.asList(names));

        if(nameSet.size() != names.length) {
            throw new IllegalArgumentException("동일한 이름으로 경주 게임을 진행할 수 없습니다.");
        }

    }
}
