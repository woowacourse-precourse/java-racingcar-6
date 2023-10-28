package racingcar.game;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.game.car.RacingCar;
import racingcar.game.inputgenerateManager.InputGenerateManager;
import racingcar.game.outputgeneratemanager.OutputGenerateManager;

public class RacingDirector {

    private final InputGenerateManager inputGenerateManager;
    private final OutputGenerateManager outputGenerateManager;

    private final RacingSimulator racingSimulator;
    private List<RacingCar> carList = new ArrayList<>();

    public RacingDirector(InputGenerateManager inputGenerateManager, OutputGenerateManager outputGenerateManager,
                          RacingSimulator racingSimulator) {
        this.inputGenerateManager = inputGenerateManager;
        this.outputGenerateManager = outputGenerateManager;
        this.racingSimulator = racingSimulator;
    }


    public void startProcess() {
        outputGenerateManager.askCarName();
        String rawString = this.readLine();
        List<String> racingCarNameList = inputGenerateManager.generateInputStringSplitWithComma(rawString);
        List<RacingCar> racingCars = racingSimulator.nameToRacingCar(racingCarNameList);

        outputGenerateManager.askRepeatCount();
        String StringRepeatCount = this.readLine();
        Integer integerRepeatCount = inputGenerateManager.generateInputStringToInt(StringRepeatCount);

        racingSimulator.roundStart(racingCars,integerRepeatCount);
        outputGenerateManager.printRace(racingCars);
    }

    private String readLine() {
        return Console.readLine();
    }

    private void close() {
        Console.close();
    }
}
