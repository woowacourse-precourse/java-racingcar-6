package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Raching {
    CarManager carManager = new CarManager();
    int maximomMove;

    public Raching(int maximomMove) {
        this.maximomMove = maximomMove;
    }

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
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void ChampionPrint(ArrayList<Car> cars) {
        ArrayList<String> championList = new ArrayList<>();
        for (Car car : cars) {
            if (car.moveCount == maximomMove) {
                championList.add(car.carName);
            }
        }
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", championList));
    }
}
