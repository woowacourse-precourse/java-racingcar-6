package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import racingcar.util.RandomNumber;

public class Cars {
    private final List<Car> cars;

    public Cars(String carListString) {
        cars = addCars(carListString);
    }

    private List<Car> addCars(String carListString) {
        List<Car> carList = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(carListString,",");
        while (st.hasMoreTokens()) {
            String carNameWithWhiteSpace = st.nextToken();
            String carNameWithoutWhiteSpace = removeWhiteSpace(carNameWithWhiteSpace);
            carList.add(new Car(carNameWithoutWhiteSpace));
        }

        return carList;
    }

    private String removeWhiteSpace(String carNameWithWhiteSpace) {
        return carNameWithWhiteSpace.strip();
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
            car.move(RandomNumber.generateRandomNumber());
        }
    }
}
