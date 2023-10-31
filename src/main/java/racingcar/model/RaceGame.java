package racingcar.model;

import java.util.ArrayList;

public class RaceGame {
    private ArrayList<Car> participants;
    private ArrayList<Car> winner;
    private Integer execution_cnt;

    public RaceGame(ArrayList<Car> participants, Integer execution_cnt) {
        this.participants = participants;
        this.winner = new ArrayList<>();
        this.execution_cnt = execution_cnt;
    }

    public ArrayList<Car> getParticipants() {
        return participants;
    }

    public ArrayList<Car> getWinner() {
        return winner;
    }

    public void setWinner(ArrayList<Car> winner) {
        this.winner = winner;
    }

    public Integer getExecution_cnt() {
        return execution_cnt;
    }
}
