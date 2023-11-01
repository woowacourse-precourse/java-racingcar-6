package racingcar.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Cars {
    private final List<Car> cars;

    public Cars(String carListString) {
        cars = addCars(carListString);
    }

    public List<Car> addCars(String carListString) {
        List<Car> carList = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(carListString,",");
        while (st.hasMoreTokens()) {
            carList.add(new Car(st.nextToken()));
        }

        return carList;
    }

    public int size() {
        return cars.size();
    }

    public Car get(int index) {
        return cars.get(index);
    }

    public void carsMoving(Cars cars) {
        for (int i=0; i<cars.size(); i++) {
            Car car = cars.get(i);
            car.move();
        }
    }
}
