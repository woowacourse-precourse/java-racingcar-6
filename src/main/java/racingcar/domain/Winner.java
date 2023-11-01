package racingcar.domain;

import java.util.ArrayList;

public class Winner {
    private ArrayList<String> name;
    private int score;

    public Winner(ArrayList<String> name, int score) {
        this.name = name;
        this.score = score;
    }

    public ArrayList<String> getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
