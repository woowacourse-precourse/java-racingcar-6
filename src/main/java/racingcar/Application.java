package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.CarRaceController;

public class Application {
    public static void main(String[] args) {
        CarRaceController controller = new CarRaceController();
        controller.raceStart();
        Console.close();
    }
}
