package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarList {
    private final ArrayList<Car> cars = new ArrayList<>();

    public CarList(String[] cars) {
        for (String car : cars) {
            this.cars.add(new Car(car));
        }
    }

    public ArrayList<Car> turnGoOrStay() {
        for (Car car : cars) {
            car.go();
        }
        return cars;
    }


    public List<String> getWinnerNames() {
        int maxPosition = ArrayMax(getCarsPositions());
        List<String> winners = new ArrayList<>();
        List<Car> winsCars = cars.stream().filter(car -> car.getPosition() == maxPosition).collect(Collectors.toList());
        for (Car car : winsCars) {
            winners.add(car.getName());
        }
        return winners;
    }

    private ArrayList<Integer> getCarsPositions() {
        ArrayList<Integer> positionArray = new ArrayList<>();
        for (Car car : cars) {
            positionArray.add(car.getPosition());
        }
        return positionArray;
    }

    private static int ArrayMax(ArrayList<Integer> positions) {
        return Collections.max(positions);

    }
}
