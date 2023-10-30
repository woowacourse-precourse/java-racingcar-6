package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.zip.CheckedOutputStream;

public class Raching {
    static final CarManager carManager = new CarManager();
    static final int maximomMove = carManager.inputForCarMove();

    public void generateRandomNumber(ArrayList<Car> cars) {
        for (Car car : cars) {
            int pickNum = Randoms.pickNumberInRange(0,9);
            car.pickNumber = pickNum;
        }
    }

    public void shouldMoveForward(ArrayList<Car> cars) {
        for (Car car : cars) {
            if (car.pickNumber >= 4) {
                car.moveCount++;
            }
        }
    }

    public void RoundResultPrint(ArrayList<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.carName + " : ");
            for (int i = 0; i<car.moveCount; i++) {
                System.out.println("-");
            }
            System.out.println();
        }
    }

}
