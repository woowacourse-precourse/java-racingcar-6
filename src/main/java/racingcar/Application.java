package racingcar;

import Model.RaceCarNames;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static RaceCarNames raceCarNames;

    public static void main(String[] args) {

    }

    public static void receiveRaceCarNames() {
        String input = Console.readLine();
        raceCarNames = new RaceCarNames(input);
    }

    // test용 코드
    public static RaceCarNames getRaceCarNames() {
        return raceCarNames;
    }
}
