package basis;

import static constant.Constant.RUN_RESULT_START_MESSAGE;
import static constant.Constant.WINNER_RESULT_MESSAGE;

import io.UserInput;
import java.util.LinkedHashMap;

public class Race {
    static MovingStatus movingStatus = new MovingStatus();
    static WinnerResult winnerResult = new WinnerResult();
    static UserInput userInterface = new UserInput();

    public void run() {

        LinkedHashMap<String, String> carNameHashMap = userInterface.getCarNameHashMap();
        int attemptsNumber = userInterface.getAttemptsNumber();
        System.out.println();
        System.out.println(RUN_RESULT_START_MESSAGE);
        movingStatus.printRaceResult(attemptsNumber, carNameHashMap);
        System.out.print(WINNER_RESULT_MESSAGE);
        winnerResult.printWinner(carNameHashMap);
    }
}