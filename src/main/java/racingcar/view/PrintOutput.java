package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class PrintOutput {
    public static void printMove(int move){
        for (int i = 0; i<move; i++){
            System.out.print("-");
        }
        System.out.println();
    }
    public static void printAllMove(List<Car> car_list){
        for (Car car : car_list) {
            System.out.print(car.getName() + " : ");
            printMove(car.getMove());
        }
        System.out.println();
    }
}