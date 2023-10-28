package racingcar.view;

import static racingcar.view.CarRaceMessages.RACE_WINNERS;
import static racingcar.view.CarRaceMessages.REQUEST_RACE_ROUNDS;
import static racingcar.view.CarRaceMessages.START_RACE;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.model.RacingCar;

public class View {
    public String requestRaceCars() {
        System.out.println(START_RACE);
        return Console.readLine();
    }

    public String requestRaceRounds() {
        System.out.println(REQUEST_RACE_ROUNDS);
        return Console.readLine();
    }


    public void raceRoundResult(List<RacingCar> racingCars) {
        racingCars.forEach(System.out::println);
        System.out.println();
    }

    public void raceWinners(String winnersNames) {
        System.out.println(RACE_WINNERS + winnersNames);
    }
}
