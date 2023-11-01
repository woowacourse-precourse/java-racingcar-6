package racingcar.domain;

import java.util.Collections;
import java.util.Comparator;
import racingcar.domain.Cars.Car;

public class GameResult {
    private final Cars cars;

    public GameResult(Cars cars) {
        this.cars = cars;
    }

    public void doGetResult() {
        int carIdx = 1;

        Collections.sort(cars.getCarList(), comparator);
        int maxNumberOfCarMoves = cars.getCarList().get(0).getNumberOfMoves();

        System.out.print("최종 우승자 : " + cars.getCarList().get(0).getName());
        while (cars.getCarList().get(carIdx).getNumberOfMoves() == maxNumberOfCarMoves) {
            System.out.print(", " + cars.getCarList().get(carIdx).getName());
            carIdx++;
            if (carIdx == cars.getCarList().size()) {
                break;
            }
        }
    }

    static Comparator<Car> comparator = new Comparator<Car>() {
        @Override
        public int compare(Car o1, Car o2) {
            return o2.getNumberOfMoves() - o1.getNumberOfMoves();
        }
    };
}
