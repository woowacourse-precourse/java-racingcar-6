package racingcar.View;

import java.util.ArrayList;
import java.util.List;
import racingcar.Model.Car;

public class OutView {
    public static void printCurrentRoundResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.print(car.getName() + " : ");
            for(int i=0;i<car.getStepCount();i++) {
                System.out.print("-");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
    public static void printWinnerCar(String winner) {
        System.out.print("최종 우승자 : " + winner);
    }

    public static void printWinnerCarList(String winner) {
        System.out.print("최종 우승자 : " + winner);
    }
}
