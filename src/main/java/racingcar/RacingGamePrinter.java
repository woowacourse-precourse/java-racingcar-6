package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGamePrinter {

    RacingGameCalculator racingGameCalculator = new RacingGameCalculator();
    public void printEachResult(List<Car> carList){

        for (Car car: carList) {
            System.out.print(car.getCarName() + " : ");
            for(int i=0; i<car.getGameResult(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printFinalResult(List<Car> carList){

        System.out.print("최종 우승자 : ");

        String result = racingGameCalculator.calculateFinalResult(carList);
        System.out.println(result);
    }
}
