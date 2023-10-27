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
        }
        System.out.println();
    }
}
