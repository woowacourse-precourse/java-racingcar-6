package racingcar;

import static racingcar.PrintMessage.INPUT_RACING_CAR_NAME;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class CarRacingGame {

    private static final String RACING_CAR_NAME_SEPARATOR = ",";

    public void run(){
        System.out.println(INPUT_RACING_CAR_NAME);
        String[] carNames = Console.readLine().split(RACING_CAR_NAME_SEPARATOR);
        List<RacingCar> racingCars = Arrays.stream(carNames).map(RacingCar::new).toList();
    }

}
