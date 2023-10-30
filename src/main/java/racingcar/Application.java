package racingcar;

import static constant.Constant.ATTEMPTS_NUMBER_REQUEST_MESSAGE;
import static constant.Constant.RUN_RESULT_START_MESSAGE;
import static constant.Constant.WINNER_RESULT_MESSAGE;

import basis.Converter;
import basis.MovingStatus;
import basis.WinnerResult;
import camp.nextstep.edu.missionutils.Console;
import io.UserInterface;
import java.util.LinkedHashMap;

public class Application {
    static Converter converter = new Converter();
    static MovingStatus movingStatus = new MovingStatus();
    static WinnerResult winnerResult = new WinnerResult();
    static UserInterface userInterface = new UserInterface();

    public static void main(String[] args) {
        LinkedHashMap<String,String> carNameHashMap = userInterface.getCarNameHashMap();
        System.out.println(ATTEMPTS_NUMBER_REQUEST_MESSAGE);
        String attemptsString = Console.readLine();
        int attemptsNumber = converter.wordToInt(attemptsString);
        System.out.println();
        System.out.println(RUN_RESULT_START_MESSAGE);
        movingStatus.printRaceResult(attemptsNumber, carNameHashMap);
        System.out.print(WINNER_RESULT_MESSAGE);
        winnerResult.printWinner(carNameHashMap);
    }
}