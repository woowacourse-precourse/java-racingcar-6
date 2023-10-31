package racingcar.view;

import racingcar.model.Car;

import java.util.ArrayList;

public class UserOutput {
    static public void ConsoleOutInputNames() {
        System.out.println(Message.INPUT_CAR_NAMES);
    }

    static public void consoleOutInputExecutionCnt() {
        System.out.println(Message.INPUT_EXECUTION_NUMBER);
    }

    static public void consoleOutExecutionStart() {
        System.out.println(Message.EXECUTION_RESULT);
    }

    static public void consoleOutExecutionResult(ArrayList<Car> cars) {
        for(Car car : cars){
            System.out.println(car.getName() + " : " + "-".repeat(car.getLocation()));
        }
        System.out.println();
    }

    static public void consoleOutWinner(ArrayList<Car> winners) {
        ArrayList<String> winnerNames = new ArrayList<>();
        for(Car car : winners){
            winnerNames.add(car.getName());
        }

        System.out.println(Message.WINNER_NAMES + String.join(", ", winnerNames));
    }
}
