package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    
    private List<Car> cars;

    public Cars(List<String> names) {
        this.cars = new ArrayList<>();
        namesJudege(names);
        setting(names);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveCar(RandomChance randomChance) {
        for (Car car : cars) {
            car.moveForward(randomChance.forwardCar());
        }
    }

    private void setting(List<String> names) {
        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }
    }

    private void namesJudege(List<String> names) {
        if (names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

}
