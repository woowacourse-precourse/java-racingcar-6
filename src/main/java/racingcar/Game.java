package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    User user = new User();

    private List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private void printDash(Long totalMovements) {
        for (int i = 0; i < totalMovements; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private void eachRound(List<Car> cars) {
        for (Car car : cars) {
            car.moveForward();
            System.out.print(car.getCarName() + " : ");
            printDash(car.getTotalMovements());
        }
    }

    private Long findMax(List<Car> cars) {
        Long max = 0L;
        for (Car car : cars) {
            if (max < car.getTotalMovements()) {
                max = car.getTotalMovements();
            }
        }
        return max;
    }

    private List<String> findWinner(List<Car> cars) {
        List<String> winner = new ArrayList<>();
        Long max = findMax(cars);
        for (Car car : cars) {
            if (max.equals(car.getTotalMovements())) {
                winner.add(car.getCarName());
            }
        }
        return winner;
    }

    public void play() {
        List<String> carNames = user.giveCarName();
        Long repeat = user.numberOfRepeats();
        List<Car> cars = createCars(carNames);

        for (int round = 0; round < repeat; round++) {
            eachRound(cars);
            System.out.println();
        }

        List<String> winner = findWinner(cars);
        System.out.print("최종 우승자 : ");

        System.out.print(String.join(", ", winner));
    }
}