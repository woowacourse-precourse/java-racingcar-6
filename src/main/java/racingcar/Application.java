package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.CarRaceController;

public class Application {
    public static void main(String[] args) {
        CarRaceController controller = new CarRaceController();
        // TODO: 프로그램 구현
        controller.raceStart();
        Console.close();
    }
}
