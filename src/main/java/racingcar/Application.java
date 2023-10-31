package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.RaceController;

public class Application {
    public static void main(String[] args) {
        RaceController race = new RaceController();

        String carInput = Console.readLine();
        String[] racingCarList = race.ready(carInput);

        String roundInput = Console.readLine();
        race.setRound(Integer.parseInt(roundInput));
    }
}
