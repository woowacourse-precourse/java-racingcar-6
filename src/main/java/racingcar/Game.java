package racingcar;
public class Game {
    GameProgression gameProgression = new GameProgression();
    GameResult gameResult = new GameResult(gameProgression);
    public void gameStart() {
        gameProgression.resultsPerGame();
        gameResult.GameEndResults();
    }
}

