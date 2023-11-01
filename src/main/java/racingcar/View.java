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
}
