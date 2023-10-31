package racingcar;

import static racingcar.PrintMessage.INPUT_NUMBER_OF_ATTEMPTS;
import static racingcar.PrintMessage.INPUT_RACING_CAR_NAME;

import camp.nextstep.edu.missionutils.Console;

public class CarRacingGame {

    private static final String RACING_CAR_NAME_SEPARATOR = ",";

    public void run(){
        System.out.println(INPUT_RACING_CAR_NAME);
        String[] carNames = Console.readLine().split(RACING_CAR_NAME_SEPARATOR);
        RacingCars racingCars = RacingCars.from(carNames);
        System.out.println(INPUT_NUMBER_OF_ATTEMPTS);
        String numberOfAttempts = Console.readLine();
    }

}
