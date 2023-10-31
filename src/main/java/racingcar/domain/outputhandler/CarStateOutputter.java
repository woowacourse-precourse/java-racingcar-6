package racingcar.domain.outputhandler;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.caractions.Car;


public class CarStateOutputter {
    private final List<Car> cars;

    public CarStateOutputter(List<Car> cars) {
        this.cars = cars;
    }

    public void printCarNames() {
        for (Car car : cars) {
            System.out.print(car.getName() + " ");
        }
        System.out.println();
    }

    public void printCarStates() {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getDistance(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public void startRace(int attemptNumber) {
        System.out.println("실행 결과");
        for (int i = 0; i < attemptNumber; i++) {
            for (Car car : cars) {
                car.advanceCar();
            }
            printCarStates();
            System.out.println();
        }
    }

    private List<String> selectChampion() {
        int maxDistance = 0;
        List<String> champions = new ArrayList<>();
        for (Car car : cars) {
            if (maxDistance < car.getDistance()) {
                champions.clear();
                maxDistance = car.getDistance();
                champions.add(car.getName());
            } else if (maxDistance == car.getDistance()) {
                champions.add(car.getName());
            }
        }

        return champions;
    }

    public void printChampion() {
        List<String> champions = selectChampion();
        System.out.println("최종 우승자 : " + String.join(", ", champions));
    }
}
