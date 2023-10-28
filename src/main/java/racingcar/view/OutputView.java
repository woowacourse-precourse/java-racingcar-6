package racingcar.view;

import racingcar.constants.ResultConstants;
import racingcar.model.Car;
import racingcar.model.Race;

import java.util.List;

public class OutputView {
    public static void printAllCarPosition(Race race){
        System.out.println(ResultConstants.PLAY_RESULT);
        for(Car car: race.getCars()){
            printEachCarPositon(car);
        }
        System.out.println();
    }

    public static void printEachCarPositon(Car car){
        System.out.print(car.getName());
        System.out.print(" : ");
        for(int i = 0; i < car.getPoint(); i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinner(String winner){
        System.out.print(ResultConstants.WINNER + " : ");
        System.out.println(winner);
    }
}
