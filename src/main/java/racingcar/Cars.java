package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
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

    private static void printScore(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("-");
        }
    }
}
