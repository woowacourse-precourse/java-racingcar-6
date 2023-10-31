package racingcar.console;
import camp.nextstep.edu.missionutils.Console;

import static racingcar.Execute.carNames;
import static racingcar.Execute.carRace;
import static racingcar.Execute.raceTime;
import static racingcar.util.Utils.*;

public class Input {
    public static void inputCarName() {
        String input = Console.readLine();

        input = setFormat(input);

        carNames = parseCarName(input);
        for (String carName : carNames) {
            carRace.put(carName, 0L);
        }
    }
    public static void inputRaceTime() {
        String input = Console.readLine();

        try{
            raceTime = Long.parseLong(input);
        }catch (Exception e){
            throw new IllegalArgumentException("잘못된 횟수 입력입니다.");
        }
    }
}
