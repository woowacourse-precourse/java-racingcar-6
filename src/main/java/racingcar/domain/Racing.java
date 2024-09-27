package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Racing {
    private List<Car> cars;
    private int turn;
    private List<Integer> distanceRecords;
    private List<Car> winners;

    public Racing(List<Car> cars, int turn) {
        this.cars = cars;
        this.turn = turn;
        this.distanceRecords = new ArrayList<>();
        this.winners = new ArrayList<>();
    }

    public static Racing create(RacingInfo racingInfo) {
        List<Car> cars = new ArrayList<>();
        for (String name : racingInfo.getCarNames()) {
            cars.add(new Car(name));
        }
        return new Racing(cars, racingInfo.getTurn());
    }

    public static void printEachTurn(Racing racing) {
        System.out.println("\n실행결과: ");
        int carIndex = 0;
        for (Integer movedDist : racing.distanceRecords) {
            if (carIndex == racing.cars.size()) {
                System.out.println();
                carIndex = 0;
            }
            String result = racing.cars.get(carIndex).getName() + " : " +
                    "-".repeat(movedDist);
            System.out.println(result);
            carIndex++;
        }
        System.out.println();
    }

    public static void printWinners(Racing racing) {
        List<String> winnersName = racing.winners
                .stream().map(Car::getName).toList();
        System.out.println("최종 우승자 : " + String.join(", ", winnersName));
    }

    public void start() {
        iterateEachTurn();
        selectWinners();
    }

    private void iterateEachTurn() {
        for (int i = 0; i < turn; i++) {
            for (Car car : cars) {
                car.move();
                distanceRecords.add(car.getMovedDist());
            }
        }
    }

    private void selectWinners() {
        Collections.sort(cars);
        int maxDist = cars.get(0).getMovedDist();
        for (Car car : cars) {
            if (car.getMovedDist() == maxDist) {
                winners.add(car);
            } else break;
        }
    }

    public List<Integer> getDistanceRecords() {
        return distanceRecords;
    }

    public List<Car> getWinners() {
        return winners;
    }
}
