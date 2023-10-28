package racingcar;

import Model.RaceCarNames;
import Model.TryCount;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    private static RaceCarNames raceCarNames;
    private static TryCount tryCount;

    public static void main(String[] args) {

    }

    public static void receiveRaceCarNames() {
        String raceCarNamesinput = Console.readLine();
        raceCarNames = new RaceCarNames(raceCarNamesinput);
    }

    public static void receiveTryCount() {
        String tryCountInput = Console.readLine();
        tryCount = new TryCount(tryCountInput);
    }

    // test용 코드
    public static RaceCarNames getRaceCarNames() {
        return raceCarNames;
    }

    public static TryCount getTryCount() {
        return tryCount;
    }
}
