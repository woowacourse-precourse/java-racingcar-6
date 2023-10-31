package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Referee;

import java.util.Arrays;

public class RacingGame {

    private final Referee referee = new Referee();

    public void start() {
        String carsInput = Console.readLine();
        addCarsToReferee(carsInput);

        int tryCount = Integer.parseInt(Console.readLine());

        for (int i = 0; i < tryCount; i++) {
            referee.startTurn();
        }
    }

    private void addCarsToReferee(String carsInput) {
        Arrays.stream(carsInput.split(",")).forEach(referee::addCar);
    }
}
