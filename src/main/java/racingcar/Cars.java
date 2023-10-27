package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Cars {
    private final List<Car> carList;

    public static Cars createCars(String[] names) {
        List<Car> carList = Arrays.stream(names)
                .map(Car::new)
                .toList();

        return new Cars(carList);
    }

    private Cars(List<Car> carList) {
        this.carList = carList;
    }

    public void moveCars() {
        for (Car car : carList) {
            tryToMoveCar(car);
        }
    }

    private void tryToMoveCar(Car car) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            car.increaseMoveCount();
        }
    }

    public List<String> getWinner() {
        int winnerScore = carList.stream()
                .map(Car::getMoveCount)
                .max(Comparator.naturalOrder())
                .get();

        return carList.stream()
                .filter(car -> car.getMoveCount() == winnerScore)
                .map(Car::getName)
                .toList();
    }

    public static void printScore(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("-");
        }
    }
}
