package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;

public class Cars {
    List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public void calculateMoveCount() {
        for (Car car : carList) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.increaseMoveCount();
            }
            int count = car.getMoveCount();
            System.out.print(car.getName() + " " + ":" + " ");
            printScore(count);
            System.out.println();
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

    private static void printScore(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("-");
        }
    }
}
