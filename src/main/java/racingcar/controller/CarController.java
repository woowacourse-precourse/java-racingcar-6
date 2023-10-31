package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import racingcar.model.Car;

public class CarController {

    public ArrayList<Car> createCars(String names) {
        ArrayList<Car> carList = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(names, ",");

        while (stringTokenizer.hasMoreTokens()) {
            String name = stringTokenizer.nextToken();
            carList.add(new Car(name));
        }
        return carList;
    }

    public void race(Car car) {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        if (randomNum < 4) {
            return;
        }
        car.addDistance();
    }

    public List<String> checkWinner(ArrayList<Car> cars) {
        int max = cars.stream().mapToInt(Car::getDistance).max().getAsInt();
        return cars.stream().filter(car -> car.getDistance() == max).map(Car::getName).toList();
    }
}
