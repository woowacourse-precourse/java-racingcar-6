package racingcar;

import java.util.ArrayList;

public class View {
    public static void printPositionState(ArrayList<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.returnCarName() + " : ");

            for (int i = 0; i < car.returnCarPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void printWinner(ArrayList<Car> winners) {
        System.out.print("최종 우승자 : ");
        for (Car winner : winners) {
            System.out.print(winner.returnCarName());

            if (winners.indexOf(winner) != winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
