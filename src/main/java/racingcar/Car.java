package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Car {
    private int count;
    private final String name;

    public Car(String inputName) {
        count = 0;
        name = inputName;
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public void move() {
        count++;
    }

    public List<Car> strToCar(String[] input){
        List<Car> cars = new ArrayList<>();
        for(String player : input){
            cars.add(new Car(player));
        }
        return cars;
    }

}
