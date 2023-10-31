package racingcar;

import java.util.ArrayList;

public class OutputView {

    public static void printRoundResult(ArrayList<Car> carList){

        for (Car car : carList) {
            System.out.println(car.name + " : ");
        }
    }
    public static void printWinner(ArrayList<String> winnerList){

    }
}
