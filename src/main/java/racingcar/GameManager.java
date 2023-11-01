package racingcar;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class GameManager {
    private final Input input = new Input();
    private final RacingScoreBoard racingScoreBoard;
    private final RandomNumber randomNumber = new RandomNumber();

    public GameManager() {
        String carNames = input.carName();
        racingScoreBoard = new RacingScoreBoard(carNames);
    }

    public void startGame() {
        int rounds = input.roundNumber();
        Output.printRoundStartMessage();
        for (int i = 0; i < rounds; i++) {
            playRound();
            Map<String, Integer> currentPositions = racingScoreBoard.currentScores();
            Output.printRoundResult(currentPositions);
        }
        Output.printWinners(getWinners());
    }

    private void playRound() {
        for (String car : racingScoreBoard.currentScores().keySet()) {
            if (randomNumber.generator() >= 4) {
                racingScoreBoard.moveCar(car);
            }
        }
    }

    private int findMaxPosition() {
        return Collections.max(racingScoreBoard.currentScores().values());
    }

    private List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        int maxPosition = findMaxPosition();
        for (Map.Entry<String, Integer> entry : racingScoreBoard.currentScores().entrySet()) {
            if (entry.getValue() == maxPosition) {
                winners.add(entry.getKey());
            }
        }
        return winners;
    }

}
