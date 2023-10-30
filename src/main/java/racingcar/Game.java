package racingcar;


import java.util.ArrayList;
import java.util.List;

public class Game {

    private static List<Car> carList = new ArrayList<>();

    public static void run() {

        Output.startMessage();
        String[] carName = Input.carName();
        int round = 0;

        for (int i = 0; i < carName.length; i++) {
            carList.add(new Car(carName[i]));
        }

        Output.roundMessage();
        round = Input.gameRound();


        Output.resultStartMessage();
        for (int i = 0; i < round; i++) {
            Action.moveCar(carList);
            Output.printResult(carList);
        }

        Output.printWinner(carList);


    }
}
