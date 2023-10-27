package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racingcar.util.Printer;
import racingcar.util.UserInput;
import racingcar.util.Validation;

public class RaceGame {
    Printer printer = new Printer();
    UserInput userInput = new UserInput();
    Engine engine = new Engine();

    public void gameStart() {
        printer.printStartMessage();
        List<String> carNames = userInput.getCarNames();
        printer.printRequestRoundMessage();
        int gameRound = userInput.getGameRound();

        Map<String, StringBuilder> scoreBoard = new LinkedHashMap<>();
        for (int i = 0; i < carNames.size(); i++) {
            scoreBoard.put(carNames.get(i), new StringBuilder());
        }

        int[] forwardCount = new int[carNames.size()];
        for (int i = 0; i < gameRound; i++) {
            for (int j = 0; j < carNames.size(); j++) {
                if (engine.rollDice()) {
                    engine.moveForward(scoreBoard.get(carNames.get(j)));
                    forwardCount[j]++; // 해당 자동차의 점수 올리기
                }
            }
        }
        List<String> winningList = new ArrayList<>();

        int winPoint = Arrays.stream(forwardCount).max().getAsInt();
        scoreBoard.forEach((key, value) -> {
            if (value.length() == winPoint) {
                winningList.add(key);
            }
        });
    }
}
