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
        for (int i = 0; i<car_list.size(); i++){
            System.out.print(car_list.get(i).getName() + " : ");
            printMove(car_list.get(i).getMove());
        }
    }
}
