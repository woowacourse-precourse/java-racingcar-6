package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

import static racingcar.domain.Message.FINAL_WINNER;

public class OutputView {

    public static void printResult(List<Car> cars){
        for(Car car : cars){
            System.out.print(car.getName() + " : ");
            printDashMark(car.getMove());
        }
        System.out.print("\n");
    }

    public static void printDashMark(int move){
        for(int i = 0; i<move; i++){
            System.out.print("-");
        }
        System.out.print("\n");
    }

    public static void printFinalWinner(List<String> finalWinner){
        System.out.print(FINAL_WINNER);

        for(int i = 0; i<finalWinner.size(); i++){
            System.out.print(" " + finalWinner.get(i));
            if(i != finalWinner.size()-1)
                System.out.print (",");
        }
    }





}
