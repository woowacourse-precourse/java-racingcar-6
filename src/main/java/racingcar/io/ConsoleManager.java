package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.car.dto.RaceResult;

import java.util.List;

public class ConsoleManager implements Input, Output{

    @Override
    public String readCarNames() {
        printGameMessage(GameMessage.INPUT_CAR_NAMES_MESSAGE);
        return Console.readLine();
    }

    @Override
    public String readGameCount() {
        printGameMessage(GameMessage.INPUT_GAME_COUNT);
        return Console.readLine();
    }

    @Override
    public void printGameMessage(GameMessage gameMessage) {
        System.out.println(gameMessage.getMessage());
    }

    @Override
    public void printRaceResult(List<RaceResult> raceResults) {
        StringBuilder sb = new StringBuilder();
        for(RaceResult result : raceResults){
            sb.append(result.name())
                    .append(" : ")
                    .append("-".repeat(result.position()))
                    .append("\n");
        }
        System.out.println(sb.toString());
    }
}
