package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class User {
    private Map<String, Integer> cars_map;
    public User(){
        this.cars_map = new HashMap<>();
    }
    public void inputCar(){
        String name = Console.readLine();
        String[] cars = name.split(",");
        for (String car : cars) {
            if (car.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해야 합니다.");
            }
        }
        Set<String> carSet = new HashSet<>(Arrays.asList(cars));
        if (carSet.size() != cars.length) {
            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
        }
        for(String car : cars) {
            cars_map.put(car, 0);
        }
    }
    public Map<String, Integer> getCars_map(){
        return cars_map;
    }
}
