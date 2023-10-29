package racingcar.view;

import racingcar.domain.Car;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintOutput {
    public static void printMove(int move){
        for (int i = 0; i<move; i++){
            System.out.print("-");
        }
        System.out.println();
    }
    public static void printAllMove(HashMap<String, Integer> car_list){
        for (Map.Entry<String,Integer> item : car_list.entrySet()) {
            System.out.print(item.getKey() + " : ");
            printMove(item.getValue());
        }
        System.out.println();
    }
}