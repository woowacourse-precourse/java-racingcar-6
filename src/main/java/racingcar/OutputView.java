package racingcar;

import java.util.List;

public class OutputView {

    public static void printRoundResult(CarList carList){

        for (Car car : carList.carList) {
            System.out.println(car.name + " : ");
        }
    }
    public static void printWinner(List<String> winnerList){

    }
}
