package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.RaceController;
import racingcar.domain.RacingCar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        RaceController race = new RaceController();

        String carInput = Console.readLine();
        List<RacingCar> racingCarList = race.ready(carInput);

        String roundInput = Console.readLine();
        race.setRound(Integer.parseInt(roundInput));

        race.start(racingCarList);
    }
}
