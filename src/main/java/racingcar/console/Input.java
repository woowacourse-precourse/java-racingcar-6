package racingcar.console;
import camp.nextstep.edu.missionutils.Console;

import static racingcar.Execute.carNames;
import static racingcar.Execute.carRace;
import static racingcar.Execute.raceTime;
import static racingcar.resource.ConsoleRes.*;
import static racingcar.util.Utils.*;

public class Input {
    public static void inputCarName() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        String input = Console.readLine();

        input = setFormat(input);

        carNames = parseCarName(input);
        for (String carName : carNames) {
            carRace.put(carName, 0L);
        }
    }
    public static void inputRaceTime() {
        System.out.println(NUMBER_INPUT_MESSAGE);
        String input = Console.readLine();

        try{
            raceTime = Long.parseLong(input);
        }catch (Exception e){
            throw new IllegalArgumentException(WRONG_NUMBER);
        }
    }
}
