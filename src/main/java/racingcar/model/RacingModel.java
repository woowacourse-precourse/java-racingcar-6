package racingcar.model;

public class RacingModel {

    private String[] players;
    private int[] moving_distances;
    private int number_of_times;

    // (기본 생성자로만 객체를 생성할 수 있게 만들었습니다)
    public void setPlayers(String[] players) {
        this.players = players;
        setMoving_distance(); // palyers값이 들어오면 각 선수들의 이동거리 초기화
    }

    private void setMoving_distance() { //
        moving_distances = new int[this.players.length];
    }

    public void setMoving_distance(int[] moving_distance) {
        this.moving_distances = moving_distance;
    }

    public void setNumber_of_times(int times) {
        this.number_of_times = times;
    }

    public String[] getPlayers() {
        return players;
    }

    public int getNumber_of_times() {
        return number_of_times;
    }

    public int[] getMoving_distance() {
        return moving_distances;
    }


}
