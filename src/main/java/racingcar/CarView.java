package racingcar;

import java.util.ArrayList;

public class CarView {
    public static void printPositionState(ArrayList<CarObject> cars) {
        for (CarObject car : cars) {
            System.out.print(car.getCarName() + " : ");

            for (int i = 0; i < car.getCarPosition(); i++) {
                System.out.print("-");
            }

            System.out.println();
        }
        System.out.println();
    }

    static void printWinner(ArrayList<CarObject> winners) {
        System.out.print("최종 우승자 : ");

        for (CarObject winner : winners) {
            System.out.print(winner.getCarName());

            if (winners.indexOf(winner) != winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
