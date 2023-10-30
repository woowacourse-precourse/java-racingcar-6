package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Referee;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Referee referee = new Referee();

        referee.notifyInsertCars();
        referee.setCars(Console.readLine());

        referee.notifyNumOfGame();
        referee.setNumOfGame(Console.readLine());

        referee.notifyResult();
        for (int i = 0; i < referee.getNumOfGame(); i++) {
            referee.moveCars();
            referee.showCarsStatus();
        }

        referee.showWinners();

    }
}
