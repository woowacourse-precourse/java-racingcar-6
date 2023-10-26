package racingcar.module;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Race {
    ArrayList<Car> carList = new ArrayList<>();

    public void addCar(Car car) {
        carList.add(car);
    }

    public ArrayList<String> getWinner() {
        int max = findFarthest();

        return carList.stream()
                .filter(e -> e.getPos() == max)
                .map(Car::getName)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public void simulateTurn() {
        carList.forEach(Car::turnAction);
    }

    public ArrayList<Car> getCarList() {
        return carList;
    }

    int findFarthest() {
        Comparator<Car> compareByPose = Comparator.comparingInt(Car::getPos);
        return carList.stream()
                .max(compareByPose)
                .orElseThrow(NoSuchElementException::new)
                .getPos();
    }


}
