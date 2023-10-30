package racingcar.view;

import racingcar.model.Car;

import java.util.List;

import static racingcar.view.PrintMessage.*;

public class OutputView {

    public static void printResultMessage(){
        System.out.println(RESULT_MESSAGE);
    }

    public static void printRoundResult(List<Car> carList){
        for (Car car : carList){
            System.out.printf(ROUND_RESULT, car.getCarName(), DISTANCE_RESULT.repeat(car.getDistance()));
            System.out.println();
        }
        System.out.println();
    }

    public static void printWinner(List<String> winnerList){
        System.out.print(WINNER);

        String winnerResult = String.join(DELIMITER, winnerList);
        System.out.println(winnerResult);
    }
}
