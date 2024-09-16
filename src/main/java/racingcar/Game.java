package racingcar;

import java.util.LinkedHashMap;

public class Game {
    public void process() {
        Start start = new Start();
        start.getInput();

        Play play = new Play();
        LinkedHashMap<String, Integer> results = play.outputView(start);

        Referee referee = new Referee();
        referee.outputView(results);
    }
}