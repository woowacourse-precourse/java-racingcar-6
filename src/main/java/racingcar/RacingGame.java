package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.data.Referee;

import java.util.Arrays;

public class RacingGame {

    private final Referee referee = new Referee();

    public void start() {
        String carsInput = Console.readLine();
        addCarsToReferee(carsInput);

        int tryCount = Integer.parseInt(Console.readLine());

    }

    private void addCarsToReferee(String carsInput) {
        Arrays.stream(carsInput.split(","))
                .forEach(referee::addCar);
    }
}
