package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {

    public static void printResult(List<Car> carList) {

        for (Car car : carList) {
            printCarStatus(car);
        }

        System.out.println();
    }

    public static void printCarStatus(Car car) {

        System.out.print(car.getName() + " : ");

        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }

        System.out.println();
    }


    public static void printWinner(List<Car> WinnerList) {

        System.out.print("최종 우승자 : ");

        for (Car car : WinnerList) {
            System.out.print(car.getName() + ", ");
        }

        System.out.println();
    }
}
