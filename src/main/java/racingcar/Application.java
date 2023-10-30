package racingcar;

import static constant.Constant.RUN_RESULT_START_MESSAGE;
import static constant.Constant.WINNER_RESULT_MESSAGE;

import basis.MovingStatus;
import basis.WinnerResult;
import io.UserInterface;
import java.util.LinkedHashMap;

public class Application {
    static MovingStatus movingStatus = new MovingStatus();
    static WinnerResult winnerResult = new WinnerResult();
    static UserInterface userInterface = new UserInterface();

    public static void main(String[] args) {
        LinkedHashMap<String, String> carNameHashMap = userInterface.getCarNameHashMap();
        int attemptsNumber = userInterface.getAttemptsNumber();
        System.out.println();
        System.out.println(RUN_RESULT_START_MESSAGE);
        movingStatus.printRaceResult(attemptsNumber, carNameHashMap);
        System.out.print(WINNER_RESULT_MESSAGE);
        winnerResult.printWinner(carNameHashMap);
    }
}