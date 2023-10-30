package racingcar;
import camp.nextstep.edu.missionutils.Console;

public class MoveInput {
    private final String move;

    MoveInput(){
      move = Console.readLine();
    }

    public String getMove(){
        return move;
    }
}
