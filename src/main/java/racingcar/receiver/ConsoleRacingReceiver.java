package racingcar.receiver;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class ConsoleRacingReceiver implements RacingReceiver {


    @Override
    public String receive() {
        return readLine();
    }
}
