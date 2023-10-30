package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Referee;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;



public class Application {
    public static void main(String[] args) {
        Referee referee = new Referee();

        referee.notifyInsertCars();
        referee.setCars(Console.readLine());

        referee.notifyNumOfGame();
        referee.setNumOfGame(Integer.parseInt(Console.readLine()));

    }
}
