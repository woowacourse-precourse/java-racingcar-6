package racingcar.view;

import racingcar.Constants;
import racingcar.model.Car;
import java.util.ArrayList;


public class OutputView {
    public static void printRace(ArrayList<Car> carList){
        printRaceInfo();
        for (Car car : carList) {
            System.out.println(car.getName()
                    + Constants.COLON
                    + Constants.DASH.repeat(car.getPosition()));
        }
    }

    public static void printWinner(ArrayList<String> winnerList){
        System.out.println("\n최종 우승자 : " + String.join(Constants.COMMA, winnerList));
    }

    public static void printRaceInfo(){
        System.out.println("\n실행 결과");
    }
}
