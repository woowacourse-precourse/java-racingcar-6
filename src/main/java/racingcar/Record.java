package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Record {
    private List<RaceCar> cars;

    public void setCars(List<String> carNames) {
        List<RaceCar> cars = new ArrayList<>();

        for (String name: carNames) {
            cars.add(new RaceCar(name));
        }
        this.cars = cars;
    }

    public void runCars() {
        for (RaceCar car: cars) {
            car.run();
        }
    }

    public void getWinner() {
        int distance = cars.stream()
                .max(Comparator.comparing(RaceCar::getDistance))
                .orElseThrow()
                .getDistance();

        List<String> winner = cars.stream()
                .filter(car -> car.getDistance() == distance)
                .map(RaceCar::getName)
                .collect(Collectors.toList());

        System.out.println("최종 우승자 : " + String.join(", ", winner));
    }

    public void getRecord() {
        for (RaceCar car: cars) {
            System.out.printf("%s : ", car.getName().trim());
            System.out.println("-".repeat(car.getDistance()));
        }
        System.out.println();
    }
}