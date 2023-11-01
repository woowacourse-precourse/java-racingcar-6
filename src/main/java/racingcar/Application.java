package racingcar;

import static racingcar.constants.Messages.*;
import static racingcar.GetInput.*;
import static racingcar.CarSet.*;

import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        System.out.println(namingCarMessage);
        String carNames = getCarNames();

        ArrayList<Car> cars = setCar(carNames);

        System.out.println(getCountsMessage);
        int counts = getCounts();

        System.out.println(printGamingMessage);
        Game.runGame(cars, counts);

        System.out.print(printWinnerMessage);
        ArrayList<Car> winners = Game.getWinner(cars);
        for (Car winner : winners) {
            System.out.print(winner.name + " ");
        }

    }
}
