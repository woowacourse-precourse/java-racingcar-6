package racingcar.view;

import racingcar.constants.GameMessage;
import racingcar.model.Car;

public class OutputView {
    public static void displayTitle(){
        System.out.println(GameMessage.OUTPUT_EXECUTION_RESULTS.getMessage());
    }
    public static void displayRacingSituation(Car cars) {
        for(int i = 0; i < cars.getNames().size(); i++ ){
            System.out.print(cars.getNameByIndex(i));
            System.out.print(GameMessage.OUTPUT_COLON.getMessage());
            displayForward(cars, i);
        }
        System.out.println();
    }

    public static void displayForward(Car cars, int i) {
        for(int j = cars.getMileageByIndex(i); j > 0; j--){
            System.out.print(GameMessage.OUTPUT_FORWARD.getMessage());
        }
        System.out.println();
    }

    public static void displayWinner(Car cars) {
        System.out.print(GameMessage.OUTPUT_WINNER_ANNOUNCEMENT.getMessage());
        int size = cars.getWinnersSize();

        if(size == 1) {
            System.out.print(cars.getWinnersByIndex(0));
            return;
        }

        for (int i = 1; i < size; i++) {
            System.out.print(cars.getWinnersByIndex(i-1));
            System.out.print(GameMessage.OUTPUT_DIVISION.getMessage());
        }
        System.out.print(cars.getWinnersByIndex(size-1));
    }
}
