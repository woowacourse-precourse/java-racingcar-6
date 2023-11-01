package racingcar;

import java.util.LinkedHashMap;

public class Game {
    public void process() {

        Start start = new Start();
        start.getInput();
        Play play = new Play();
        LinkedHashMap<String, Integer> map = play.show(start);
        Referee finalResult = new Referee();
        finalResult.show(map);
    }
}