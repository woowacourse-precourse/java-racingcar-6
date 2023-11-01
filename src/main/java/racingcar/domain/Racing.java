package racingcar.domain;

import java.util.*;

public class Racing {
    private List<Car> cars;
    private int turn;
    private List<Integer> distanceRecord;
    private List<Car> winners;
    public Racing(List<Car> cars, int turn) {
        this.cars = cars;
        this.turn = turn;
        this.distanceRecord = new ArrayList<>();
        this.winners = new ArrayList<>();
    }

    public void start() {
        for (int i = 0; i < turn; i++) {
            for (Car car : cars) {
                car.move();
                distanceRecord.add(car.getMovedDist());
            }
        }
    }

    public List<Car> selectWinners() {
        Collections.sort(cars);
        int maxDist = cars.get(0).getMovedDist();
        for (Car car : cars) {
            if (car.getMovedDist() == maxDist) {
                winners.add(car);
            } else break;
        }
        return winners;
    }

    public void printWinners() {
        List<String> winners = selectWinners()
                .stream().map(Car::getName).toList();
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public void printEachTurn() {
        System.out.println("\n실행결과: ");
        int carIndex = 0;
        for (Integer movedDist : distanceRecord) {
            if (carIndex == cars.size()) {
                System.out.println();
                carIndex = 0;
            }
            String result = cars.get(carIndex).getName() + " : " +
                    "-".repeat(movedDist);
            System.out.println(result);
            carIndex++;
        }
        System.out.println();
    }

    public static Racing create(RacingInfo racingInfo) {
        List<Car> cars = new ArrayList<>();
        for (String name : racingInfo.getCarNames()) {
            cars.add(new Car(name));
        }
        return new Racing(cars, racingInfo.getTurn());
    }
}
