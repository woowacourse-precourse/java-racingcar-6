package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.car.dto.RaceResult;

import java.util.List;

public class ConsoleManager implements Input, Output{

    @Override
    public String readCarNames() {
        printGameMessage(GameMessage.INPUT_CAR_NAMES);
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

    @Override
    public void printWinner(List<String> winners) {
        StringBuilder sb = new StringBuilder();
        sb.append(GameMessage.FINAL_WINNER.getMessage());

        for(int i=0; i<winners.size(); i++){
            sb.append(winners.get(i));
            if(i != winners.size()-1){
                sb.append(", ");
            }
        }

        System.out.println(sb.toString());
    }
}
