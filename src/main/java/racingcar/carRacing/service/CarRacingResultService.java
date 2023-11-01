package racingcar.carRacing.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import racingcar.car.model.Car;
import racingcar.carRacing.model.CarRacing;

public class CarRacingResultService {

    static public void printRacingResult(CarRacing carRacing) {
        List<Car> cars = sortResult(carRacing);
        Car lastCar = cars.get(0);

        System.out.print("최종 우승자 : ");
        System.out.print(lastCar.getName());
        for (int i = 1; i < cars.size(); i++) {
            Car car = cars.get(i);
            if (cars.get(i).getPosition().equals(lastCar.getPosition())) {
                System.out.print(", " + car.getName());
                lastCar = car;
            }
        }
        System.out.print("\n");
    }

    static public List<Car> sortResult(CarRacing carRacing) {
        List<Car> cars = carRacing.getCarList();
        Comparator<Car> comparator = Comparator.comparingInt(Car::getPosition);

        cars.sort(Collections.reverseOrder(comparator));
        return cars;
    }

    static public void printCurrentState(List<Car> cars) {
        for (Car car : cars) {
            printCarState(car);
        }
        System.out.println();
    }

    static private void printCarState(Car car) {
        String name = car.getName();
        Integer position = car.getPosition();

        System.out.print(name + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.print("\n");
    }

}
