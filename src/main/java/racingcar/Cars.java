package racingcar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import racingcar.utils.Validator;

public class Cars implements Iterable<Car> {
    private final List<Car> cars = new ArrayList<>();

    public Cars(String names) {
        Validator.validateNames(names);
        String[] carNames = names.split(",");
        for (String name : carNames) {
            cars.add(new Car(name.trim()));
        }
    }

    public int size() {
        return cars.size();
    }

    public Car getCar(int index) {
        return cars.get(index);
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }

    public List<String> findWinner(Cars cars) {
        int maxPosition = 0;
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
                winners.clear();
                winners.add(car.getName());
            } else if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        return winners;
    }
}
