package racingcar.domain;

public class RacingCar {
    private int id;
    private String name;
    private int distance;

    public String getCarName(int id) {
        return this.name;
    }

    public int getDistance(int id) {
        return this.distance;
    }

    public int getId(String name) {
        return this.id;
    }

    public void moving(int id, int forward) {
        distance += forward;
    }

    public void carDataSave(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
