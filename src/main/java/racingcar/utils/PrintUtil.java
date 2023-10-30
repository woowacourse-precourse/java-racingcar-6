package racingcar.utils;

import racingcar.game.Car;
import racingcar.game.Cars;

import java.util.List;

import static racingcar.constValue.ConstValue.*;

public class PrintUtil {
    public static void printCarNamesPrompt(){
        System.out.println(CAR_NAMES_PROMPT_MESSAGE);
    }
    public static void printTurnPrompt(){
        System.out.println(TURN_PROMPT_MESSAGE);
    }
    public static void printPlayResult(){
        System.out.println(RESULT_MESSAGE);
    }
    public static void printTurnResult(Cars cars){
        List<Car> carList = cars.getCars();
        // 입력 : Cars
        for(Car car:carList){
            String printMessage = "";
            printMessage = printMessage.concat(car.getName());
            printMessage = printMessage.concat(" : ");

            for(int i=0; i < car.getMoving();i++){
                printMessage = printMessage.concat("-");
            }

            System.out.println(printMessage);
        }
        System.out.println();
    }
    public static void printWinner(String racingWinner){
        System.out.println(WINNER_MESSAGE + racingWinner);
    }
}
