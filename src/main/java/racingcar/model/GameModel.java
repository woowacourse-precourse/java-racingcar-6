package racingcar.model;

import java.util.ArrayList;

public class GameModel {
    private ScoreBoard scoreBoard;
    private int raceTimes;

    public GameModel(String inputNames, String inputTimes) {

        String[] names = inputNames.split(",");

        this.scoreBoard = new ScoreBoard(names);
        this.raceTimes = Integer.parseInt(inputTimes);
    }

    public ArrayList<String> aggregateRoundScore() {
        raceTimes--;
        return scoreBoard.aggregateScore();
    }

    public boolean raceTimeRemain() {
        return this.raceTimes != 0;
    }


}
