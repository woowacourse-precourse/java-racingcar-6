package racingcar;

import racingcar.IO.Input.InputContext;
import racingcar.IO.Input.RaceStartCommand;
import racingcar.IO.output.OutPutContext;
import racingcar.race.OutPutCommand;
import racingcar.race.RaceContext;

public class Application {
    public static void main(String[] args) {
        RaceStartCommand raceStartCommand = InputContext.inputRacingCar().startCommand();
        OutPutCommand outPutCommand = RaceContext.start(raceStartCommand).outPutCommand();
        OutPutContext.printOutPutContents(outPutCommand);
    }
}
