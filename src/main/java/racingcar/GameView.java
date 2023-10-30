package racingcar;

import java.util.List;
import java.util.Map;

public class GameView {

    public void printMessage(String message) {
        System.out.println(message);

    }

    public void printNoEndLinePrintMessage(String message) {
        System.out.print(message);
    }

    public void printWinner(String WINNER_MESSAGE, List<String> winners) {
        String winnerNames = String.join(", ", winners);
        printNoEndLinePrintMessage(WINNER_MESSAGE + " " + winnerNames);
    }

    public void displayGameResult(String RESULT_MESSAGE, Map<String, Integer> carData) {
        printMessage(RESULT_MESSAGE);
        printResult(carData);
    }


    public void printResult(Map<String, Integer> carData) {
        for (Map.Entry<String, Integer> entry : carData.entrySet()) {
            printCarResult(entry.getKey(), entry.getValue());
        }
    }

    private void printCarResult(String carName, int position) {
        printNoEndLinePrintMessage(carName + " : ");
        for (int j = 0; j < position; j++) {
            printNoEndLinePrintMessage(GameModel.LINE);
        }
        System.out.println();
    }

}
