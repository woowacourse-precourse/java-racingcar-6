package racingcar.View;

import racingcar.model.Car;
import racingcar.constant.UserRequestMessage;
import racingcar.constant.UserResponeMessage;

import java.util.ArrayList;

public class Output {

    public static void printCarNameRequest(){
        System.out.println(UserRequestMessage.CAR_NAME_REQUEST_MESSAGE);
    }

    public static void printReqpeatRequest(){
        System.out.println(UserRequestMessage.Repeat_REQUEST_MESSAGE);
    }

    public static void printExecutResult(){
        System.out.println("\n"+ UserResponeMessage.EXECUTION_RESULT_MESSAGE);

    }

    public static void printRoundResult(ArrayList<Car> operatedCars){
        for(Car car :operatedCars){
            car.printForawrdSituation();
        }
        System.out.println();
    }

    public static void printFinalWinner(){
        System.out.print(UserResponeMessage.FINAL_WINNER_MESSAGE);
    }

    public static void printSingleWinner(Car winner){
        System.out.print(winner.getName());
    }

    public static void printMultiWinner(ArrayList<Car> winners){
        for(int i=0; i<winners.size() -1; i++){
            System.out.print(winners.get(i).getName()+", ");
        }
        System.out.print(winners.get(winners.size() -1).getName());
    }

}
