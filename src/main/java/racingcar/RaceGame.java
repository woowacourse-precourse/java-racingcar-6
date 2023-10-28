package racingcar;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racingcar.util.Printer;
import racingcar.util.UserInput;

public class RaceGame {
    Printer printer = new Printer();
    UserInput userInput = new UserInput();
    Engine engine = new Engine();

    public Map<String, StringBuilder> makeScoreBoard(List<String> carNames) {
        Map<String, StringBuilder> scoreBoard = new LinkedHashMap<>();

        for (String name : carNames) {
            scoreBoard.put(name, new StringBuilder());
        }
        return scoreBoard;
    }

    public void playOneRound(Map<String, StringBuilder> scoreBoard) {
        for (Map.Entry<String, StringBuilder> pair : scoreBoard.entrySet()) {
            if (engine.rollDice()) {
                engine.moveForward(pair.getValue());
            }
            printer.printRoundResult(pair);
        }
    }

    public void gameStart() {
        printer.printStartMessage();
        List<String> carNames = userInput.getCarNames();
        printer.printRequestRoundMessage();
        int gameRound = userInput.getGameRound();

        Map<String, StringBuilder> scoreBoard = makeScoreBoard(carNames);

        for (int j = 0; j < gameRound; j++) {
            for (Map.Entry<String, StringBuilder> pair : scoreBoard.entrySet()) {
                if (engine.rollDice()) {
                    engine.moveForward(pair.getValue());
                }
                printer.printRoundResult(pair);
            }
            System.out.println();
        }

        List<String> winningList = new ArrayList<>();
        int winPoint = scoreBoard.values()
                .stream()
                .mapToInt(StringBuilder::length)
                .max()
                .orElse(0);
        System.out.println(winPoint);

        scoreBoard.forEach((key, value) -> {
            if (value.length() == winPoint) {
                winningList.add(key);
            }
        });
        printer.printWinnersNames(winningList);
    }
}
