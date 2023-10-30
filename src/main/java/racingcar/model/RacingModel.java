package racingcar.model;

import java.util.List;

public class RacingModel {

    private List<String> players;
    private int[] moving_distances;
    private int number_of_times;

    public RacingModel(List<String> players, int number_of_times) {

        this.players = players;
        this.number_of_times = number_of_times;
        this.moving_distances = new int[players.size()];

    }

    public void setMoving_distance(int[] moving_distance) {
        this.moving_distances = moving_distance;
    }

    public List<String> getPlayers() {
        return players;
    }

    public int getNumber_of_times() {
        return number_of_times;
    }

    public int[] getMoving_distance() {
        return moving_distances;
    }

}
