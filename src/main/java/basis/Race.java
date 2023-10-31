package basis;

import static constant.Constant.RUN_RESULT_START_MESSAGE;
import static constant.Constant.WINNER_RESULT_MESSAGE;

import io.UserInput;
import java.util.LinkedHashMap;

public class Race {
    private final MovingStatus movingStatus;
    private final WinnerResult winnerResult;
    private final UserInput ui;

    public Race(MovingStatus movingStatus, WinnerResult winnerResult, UserInput ui) {
        this.movingStatus = movingStatus;
        this.winnerResult = winnerResult;
        this.ui = ui;
    }

    public void run() {
        LinkedHashMap<String, String> carNameHashMap = ui.getCarNameHashMap();
        int attemptsNumber = ui.getAttemptsNumber();
        ui.println("");
        ui.println(RUN_RESULT_START_MESSAGE);
        movingStatus.printRaceResult(attemptsNumber, carNameHashMap);
        ui.print(WINNER_RESULT_MESSAGE);
        winnerResult.printWinner(carNameHashMap);
    }
}